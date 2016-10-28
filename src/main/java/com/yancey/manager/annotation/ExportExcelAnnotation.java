package com.yancey.manager.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface ExportExcelAnnotation {

  public int index();
  
  public String desc() default "";
  
}
