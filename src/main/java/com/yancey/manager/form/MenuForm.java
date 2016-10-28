package com.yancey.manager.form;

public class MenuForm implements Cloneable {
  private Integer resourceId;
  private String  resourceName;
  private String  permission;
  private String  resourceUrl;
  private Integer parent;
  private Integer displaySort;
  private String  displayType;
  private String  description;
  private String  state;

  public String getState() {
    return state;
  }
  public void setState(String state) {
    this.state = state;
  }
  public String getPermission() {
    return permission;
  }
  public void setPermission(String permission) {
    this.permission = permission;
  }
  public String getResourceUrl() {
    return resourceUrl;
  }
  public void setResourceUrl(String resourceUrl) {
    this.resourceUrl = resourceUrl;
  }

  public Integer getParent() {
    return parent;
  }
  public void setParent(Integer parent) {
    this.parent = parent;
  }
  public Integer getDisplaySort() {
    return displaySort;
  }
  public void setDisplaySort(Integer displaySort) {
    this.displaySort = displaySort;
  }
  public String getDisplayType() {
    return displayType;
  }
  public void setDisplayType(String displayType) {
    this.displayType = displayType;
  }
  public String getDescription() {
    return description;
  }
  public void setDescription(String description) {
    this.description = description;
  }
  public Integer getResourceId() {
    return resourceId;
  }
  public void setResourceId(Integer resourceId) {
    this.resourceId = resourceId;
  }
  public String getResourceName() {
    return resourceName;
  }
  public void setResourceName(String resourceName) {
    this.resourceName = resourceName;
  }
  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
  @Override
  public String toString() {
    return "MenuForm [resourceId=" + resourceId + ", resourceName=" + resourceName + ", permission=" + permission + ", resourceUrl=" + resourceUrl
        + ", parent=" + parent + ", displaySort=" + displaySort + ", displayType=" + displayType + ", description=" + description + ", state=" + state + "]";
  }
}
