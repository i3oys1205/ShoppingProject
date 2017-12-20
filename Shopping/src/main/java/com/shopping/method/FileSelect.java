package com.shopping.method;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

public class FileSelect {

	public StringBuffer fileRead(String html , String template , HttpServletRequest request) {

		StringBuffer buffer = new StringBuffer();
		String path = null;
		if(template.equals("builder")){
			path = request.getServletContext().getRealPath("/")+"builder/editor/"+html+".html";
		}else{
			path = request.getServletContext().getRealPath("/")+"builder/view/"+html+".html";
		}
		File file = new File(path);
		boolean isExists = file.exists();
		if (isExists) {
			char[] ch = new char[(int) file.length()];
			try {
				BufferedReader br = new BufferedReader(new FileReader(file));
				br.read(ch);
				buffer.append(ch);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("No exists File");
		}
		return buffer;
	}

	public StringBuffer fileWrite(String html , String template , HttpServletRequest request ,String contents){
		StringBuffer stat = new StringBuffer();
		String path = null;
		if(template.equals("builder")){
			path = request.getServletContext().getRealPath("/")+"builder/editor/"+html+".html";
		}else{
			path = request.getServletContext().getRealPath("/")+"builder/view/"+html+".html";
		}
		try{
			BufferedWriter fw = new BufferedWriter(new FileWriter(path, false));
			fw.write(contents.toString());
			fw.flush();
			fw.close();
			stat.append("200");
		}catch(Exception e){
			e.printStackTrace();
			stat.append("400");
		}
		return stat;
	}
	
	public StringBuffer fileApply(String html , String template , HttpServletRequest request ,String contents){
		StringBuffer stat = new StringBuffer();
		String path = null;
		path = request.getServletContext().getRealPath("/")+"builder/view/"+html+".html";
		try{
			BufferedWriter fw = new BufferedWriter(new FileWriter(path, false));
			fw.write(contents.toString());
			fw.flush();
			fw.close();
			stat.append("200");
		}catch(Exception e){
			e.printStackTrace();
			stat.append("400");
		}
		return stat;
	}
}
