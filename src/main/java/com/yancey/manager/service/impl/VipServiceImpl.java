package com.yancey.manager.service.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.List;

import org.apache.http.impl.client.CloseableHttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yancey.manager.bto.VipBto;
import com.yancey.manager.bto.VipListBto;
import com.yancey.manager.common.CacheKey;
import com.yancey.manager.redis.RedisClient;
import com.yancey.manager.service.IVipService;
import com.yancey.manager.util.HtmlParserUtils;

@Service
public class VipServiceImpl implements IVipService {

	@Autowired
	private RedisClient<String, Object>              redisClient;
	
	private static final Logger logger = LoggerFactory.getLogger(VipServiceImpl.class);

	private static final String youkuUrl="http://www.mdouvip.com/youku";
	
	private static final String aqiyiUrl="http://www.mdouvip.com/aiqiyi";
	
	private static final String xunleiUrl="http://www.mdouvip.com/xunlei";
	
	private static final String leshiUrl="http://www.mdouvip.com/youku";
	
	@Override
	public VipListBto getVipList(CloseableHttpClient client) {
		Object obj=redisClient.get(CacheKey.getVipKey());
		if(obj==null){
			VipListBto vipListBto=new VipListBto();
			String html = HtmlParserUtils.getDataQueryHtml(client, youkuUrl);
			List<VipBto> youkuList=HtmlParserUtils.getVipList(html,client);
			
			html = HtmlParserUtils.getDataQueryHtml(client, aqiyiUrl);
			List<VipBto> aqiyiList=HtmlParserUtils.getVipList(html,client);
			
			html = HtmlParserUtils.getDataQueryHtml(client, xunleiUrl);
			List<VipBto> xunleiList=HtmlParserUtils.getVipList(html,client);
			
			vipListBto.setYouKuList(youkuList);
			vipListBto.setAiQiYiList(aqiyiList);
			vipListBto.setXunLeiList(xunleiList);
			obj=vipListBto;
			redisClient.put(CacheKey.getVipKey(), obj,3600);
		}
		return (VipListBto)obj;
	}

	public static void main(String[] args) {
		try {
			//FileReader fr=new FileReader("d://11.txt");
			InputStream is=new FileInputStream("d://11.txt");
			InputStreamReader isr1=new InputStreamReader(is,"GBK");
			OutputStream os=new FileOutputStream("d://33.txt");
			OutputStreamWriter osw=new OutputStreamWriter(os, "GBK");
			 BufferedReader br = new BufferedReader (isr1);
	         String s="";
	         String str="";
	         int tt=0;
	         char []cc=null;
	         while ((tt =isr1.read() )!=-1) {
	        	 str+=s;
	        	 System.out.println(s);
	        	 //osw.write(cc, 0, tt);
	        	 osw.write(tt);
	         }
	        // System.out.println(str);
	         //List<String> ss=HtmlParserUtils.getLinkTagValues(str);
	         //String ss=HtmlParserUtils.getHtmlValueByType(str);
	         byte []bb=new byte[1024];
	         InputStream fis=new FileInputStream("d://11.txt");
	         InputStreamReader isr=new InputStreamReader(fis,"GBK");
			 BufferedReader br1 = new BufferedReader (isr);
	         OutputStream fos=new FileOutputStream("d://22.txt");
	         FileWriter fw=new FileWriter("d://22.txt");
	         PrintWriter pw=new PrintWriter(fw);
	         int count=0;
	         String ss="";
	         while((ss=br1.readLine())!=null){
	        	 //fos.write(bb,0,count);
	        	 System.out.println(ss);
	        	 fw.write(ss+"\r\n");
	        	 //System.out.println(count);
	         }
	         
	         System.out.println(11+"\r"+22);
	        pw.close();
	        fw.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
		
		
}
