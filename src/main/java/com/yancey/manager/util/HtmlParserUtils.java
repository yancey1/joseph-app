package com.yancey.manager.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.htmlparser.Node;
import org.htmlparser.NodeFilter;
import org.htmlparser.Parser;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.lexer.Lexer;
import org.htmlparser.lexer.Page;
import org.htmlparser.nodes.TagNode;
import org.htmlparser.tags.Html;
import org.htmlparser.tags.LinkTag;
import org.htmlparser.tags.OptionTag;
import org.htmlparser.tags.SelectTag;
import org.htmlparser.util.DefaultParserFeedback;
import org.htmlparser.util.NodeList;
import org.htmlparser.util.ParserException;
import org.htmlparser.visitors.HtmlPage;
import org.htmlparser.visitors.TextExtractingVisitor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.yancey.manager.bto.VipBto;
import com.yancey.manager.domain.OptionEntity;

import edu.hziee.common.lang.DateUtil;

public class HtmlParserUtils {

	private static final Logger logger = LoggerFactory.getLogger(HtmlParserUtils.class);

	public static String getDataQueryHtml(CloseableHttpClient httpClient, String queryUrl) {
		HttpResponse response = null;
		try {
			HttpGet httpGet = new HttpGet(queryUrl);
			logger.debug("get query page html by url=[{}]", queryUrl);
			response = httpClient.execute(httpGet);
			HttpEntity httpEntity = response.getEntity();
			String html = EntityUtils.toString(response.getEntity());
			if (httpEntity != null) {
				EntityUtils.consume(httpEntity);
			}
			return html;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	private static List<OptionEntity> getSelectOptionProperties(SelectTag sTag) {
		List<OptionEntity> optionPropertyList = new ArrayList<OptionEntity>();
		NodeList childList = sTag.getChildren();
		if (childList != null) {
			for (int x = 0; x < childList.size(); x++) {
				Node childTag = childList.elementAt(x);
				if (childTag instanceof OptionTag) {
					OptionTag optionTag = (OptionTag) childTag;
					OptionEntity optionEntity = new OptionEntity();
					optionEntity.setText(optionTag.toPlainTextString());
					optionEntity.setValue(optionTag.getAttribute("value"));
					optionPropertyList.add(optionEntity);
				}
			}
		}
		return optionPropertyList;
	}

	/**
	 * 获取select组件里的value值
	 * 
	 * @param html
	 * @param attributeName
	 *            属性名
	 * @param attributeValue
	 *            属性值
	 * @return
	 */
	public static List<String> getSelectTagValues(String html, String attributeName, String attributeValue) {
		List<String> productList = new ArrayList<String>();
		Parser parser;
		try {
			parser = new Parser(html);
			NodeFilter hasAttriFilter = new HasAttributeFilter(attributeName, attributeValue);
			NodeList nodes = parser.extractAllNodesThatMatch(hasAttriFilter);
			for (int i = 0; i < nodes.size(); i++) {
				Node tag = (Node) nodes.elementAt(i);
				if (tag instanceof SelectTag) {
					SelectTag sTag = (SelectTag) tag;
					String value = sTag.getAttribute(attributeName);
					if (value.equals(attributeValue)) {
						NodeList childList = tag.getChildren();
						if (childList != null) {
							List<OptionEntity> optionList = HtmlParserUtils.getSelectOptionProperties(sTag);
							for (OptionEntity entity : optionList) {
								productList.add(entity.getValue());
							}
						}
					}
				}
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return productList;
	}

	/**
	 * 获取input组件里的value值
	 * 
	 * @param html
	 * @param attributeName
	 *            属性名
	 * @param attributeValue
	 *            属性值
	 * @return
	 */
	public static String getInputTagValues(String html, String attributeName, String attributeValue) {
		String s = "";
		Parser parser;
		try {
			parser = new Parser(html);
			NodeFilter hasAttriFilter = new HasAttributeFilter(attributeName, attributeValue);
			NodeList nodes = parser.extractAllNodesThatMatch(hasAttriFilter);
			for (int i = 0; i < nodes.size(); i++) {
				Node tag = (Node) nodes.elementAt(i);
				Html iTag = (Html) tag;
				String value = iTag.getAttribute(attributeName);
				if (value.equals(attributeValue)) {
					s = iTag.getAttribute("value");
					break;
				}

			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return s;
	}

	/**
	 * 获取input组件里的href属性值值
	 * 
	 */
	public static List<String> getLinkTagValues(String html) {

		List<String> list = new ArrayList<String>();
		String s = "";
		Parser parser;
		try {
			parser = new Parser(html);
			NodeList nodeList = parser.extractAllNodesThatMatch(new NodeFilter() {
				// 实现该方法,用以过滤标签
				public boolean accept(Node node) {
					if (node instanceof LinkTag)// 标记
						return true;
					return false;
				}

			});
			// 打印
			for (int i = 0; i < nodeList.size(); i++) {
				LinkTag n = (LinkTag) nodeList.elementAt(i);
				s = n.getAttribute("href");
				if (!s.contains(".html")) {
					continue;
				}
				// s = s.replace(" 00:00:00.0", "");

				list.add(s);
			}
		} catch (ParserException e) {
			e.printStackTrace();
		}
		return list;
	}

	public static Parser createParser(String inputHTML) {
		Lexer mLexer = new Lexer(new Page(inputHTML));
		return new Parser(mLexer, new DefaultParserFeedback(DefaultParserFeedback.QUIET));
	}

	private static String decode(String str) {
		String[] tmp = str.split(";&#|&#|;");
		StringBuffer sb = new StringBuffer("");
		for (int i = 0; i < tmp.length; i++) {
			if (tmp[i].matches("\\d{5}")) {
				sb.append((char) Integer.parseInt(tmp[i]));
			} else {
				sb.append(tmp[i]);
			}
		}
		return sb.toString();
	}

	public static List<VipBto> getVipList(String html, CloseableHttpClient client) {
		List<VipBto> vipList = new ArrayList<VipBto>();
		try {
			NodeList nodelist = getBodyNode(html);
			nodelist = getNodeList("div", nodelist);
			nodelist = getNodeList("article", nodelist);
			for (int i = 0; i < nodelist.size() / 2; i++) {
				TagNode articleNode = (TagNode) nodelist.elementAt(i);
				TagNode aNode = (TagNode) articleNode.getNextSibling();
				String url = aNode.getAttribute("href");
				List<VipBto> list = getVipListByHtml(url, client);
				vipList.addAll(list);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return vipList;
	}

	public static List<VipBto> getVipListByHtml(String url, CloseableHttpClient client) {
		List<VipBto> vipList = new ArrayList<VipBto>();
		String html = getDataQueryHtml(client, url);
		NodeList nodelist = getBodyNode(html);
		nodelist = getNodeList("p", nodelist);
		for (int i = 0; i < nodelist.size(); i++) {
			TagNode node = (TagNode) nodelist.elementAt(i);
			// System.out.println(node.toPlainTextString()+"***"+node.toTagHtml());
			String text = getNodeText(node.toHtml());
			if (StringUtils.isNotBlank(text)) {
				if (text.contains("账号：") && text.contains("密码") && text.length() < 50) {
					VipBto bto = new VipBto();
					String[] ss = text.split(" ");
					String accountName = "";
					String password = "";
					if (ss.length == 2) {
						accountName = ss[0].split("：")[1];
						password = ss[1].split("：")[1];
					} else if (ss.length == 3) {
						accountName = ss[0].split("：")[1];
						password = ss[2];
					} else {
						continue;
					}
					bto.setAccountName(accountName);
					bto.setPassword(password);
					vipList.add(bto);
				}
			}
			// System.out.println(node.);
		}
		return vipList;
	}

	public static NodeList getBodyNode(String html) {
		NodeList nodelist = null;
		try {
			Parser parser = Parser.createParser(html, "utf-8");
			HtmlPage htmlpage = new HtmlPage(parser);
			parser.visitAllNodesWith(htmlpage);
			nodelist = htmlpage.getBody();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nodelist;
	}

	public static NodeList getNodeList(String tag, NodeList nodelist) {
		NodeFilter filter = new TagNameFilter(tag);
		nodelist = nodelist.extractAllNodesThatMatch(filter, true);
		return nodelist;
	}

	public static String getNodeText(String html) {
		String text = "";
		try {
			Parser parser = new Parser(html);
			TextExtractingVisitor visitor = new TextExtractingVisitor();
			parser.visitAllNodesWith(visitor);
			text = visitor.getExtractedText();
		} catch (Exception e) {
			logger.error(e.getMessage());
		}
		return text;
	}

	public static void main(String[] args) {
		String string = "账号：13757606097 密码：tel85288111";

	}

}
