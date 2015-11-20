package com.minor.autocode;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.google.common.base.Joiner;
import com.google.common.collect.Lists;

public enum Enumeration {
	mapper("mapper", "/dao", "Mapper.java", "mapper.vm"),
	service("service", "/service", "service.java", "service.vm");
	
	private String type;
	private String targetDir;
	private String fileName;
	private String template;
	
	private Enumeration(){
	}
	
	private Enumeration(String type, String targetDir, String fileName,
			String template){
		
		this.type = type;
		this.targetDir = targetDir;
		this.fileName = fileName;
		this.template = template;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.JSON_STYLE);
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getTargetDir() {
		return targetDir;
	}

	public void setTargetDir(String targetDir) {
		this.targetDir = targetDir;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getTemplate() {
		return template;
	}

	public void setTemplate(String template) {
		this.template = template;
	}
	
	public static Enumeration getByType(String type){
		if(StringUtils.isBlank(type)){
			return null;
		}
		
		for(Enumeration packageDirType : values()){
			if(StringUtils.equals(type, packageDirType.getType())){
				return packageDirType;
			}
		}
		
		return null;
	}
	
	public static String getDefaultConfigLayer(){
		List configs = Lists.newArrayList();
		for(Enumeration pakcageConfigDirType : values()){
			configs.add(pakcageConfigDirType.getType());
		}
		
		return Joiner.on(",").join(configs);
	}
	
	public static void main(String args[]){
			Enumeration[] eArray = Enumeration.values();
			for(Enumeration e: eArray){
				System.out.println(e);
			}
	}
}
