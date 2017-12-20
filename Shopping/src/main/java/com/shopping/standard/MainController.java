package com.shopping.standard;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.shopping.method.FileSelect;

@RestController
public class MainController {

	ModelAndView mv = new ModelAndView();

	@RequestMapping("/")
	public ModelAndView indexView(HttpSession session, HttpServletRequest request){
		session.setAttribute("pageTitle", "해오름 유니폼");
		mv.setViewName("index");
		return mv;
	}
	@RequestMapping("/main")
	public ModelAndView mainView(){
		mv.setViewName("main");
		return mv;
	}
	@RequestMapping("/admin")
	public ModelAndView adminView(){
		mv.setViewName("admin/admin");
		return mv;
	}
	@RequestMapping("/display")
	public ModelAndView displayView(){
		mv.setViewName("admin/display");
		return mv;
	}

	@RequestMapping("/action")
	public @ResponseBody ArrayList<HashMap<Object,Object>> actionReturn(HttpServletRequest httpServletRequest) {

		Map<String, String[]> requestParameterMap = httpServletRequest.getParameterMap();
		ArrayList<HashMap<Object,Object>> returnArray = new ArrayList<HashMap<Object,Object>>();
		Class noparams[] = {};
		Class[]  paramString = null;
		String[] methodParam = null;

		System.out.println("JAVA RequestMapping : [[ Action ]]");
		for (String key : requestParameterMap.keySet()) {
			System.out.println("Key : " + key + ", Value: "+ requestParameterMap.get(key)[0]);
		}

		try{
			if(requestParameterMap.size() == 3){
				paramString = noparams;
				methodParam = null;
			}else{
				paramString = new Class[requestParameterMap.size()-3];
				methodParam = new String[requestParameterMap.size()-3];
				List keys = new ArrayList(requestParameterMap.keySet());
				for(int i=0; i<requestParameterMap.size()-3; i++){
					paramString[i]  = String.class;
					methodParam[i]  = requestParameterMap.get((String) keys.get(i+3))[0];
					System.out.println(requestParameterMap.get((String) keys.get(i+3))[0]);
				}				
			}

		}catch(Exception e){
			e.printStackTrace();
		}

		if(requestParameterMap.get("type")[0].equals("insert")){
			try{
				Class<?> cls = Class.forName("com.shopping.dao.InsertDAO");
				Object obj = cls.newInstance();
				Method method = cls.getDeclaredMethod(requestParameterMap.get("method")[0], paramString);
				returnArray = (ArrayList<HashMap<Object, Object>>) method.invoke(obj, methodParam);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(requestParameterMap.get("type")[0].equals("select")){
			try{
				Class<?> cls = Class.forName("com.shopping.dao.SelectDAO");
				Object obj = cls.newInstance();
				Method method = cls.getDeclaredMethod(requestParameterMap.get("method")[0], paramString);
				returnArray = (ArrayList<HashMap<Object, Object>>) method.invoke(obj, methodParam);
			}catch(Exception e){
				e.printStackTrace();
			}
		}else if(requestParameterMap.get("type")[0].equals("delete")){
			try{
				Class<?> cls = Class.forName("com.shopping.dao.DeleteDAO");
				Object obj = cls.newInstance();
				Method method = cls.getDeclaredMethod(requestParameterMap.get("method")[0], paramString);
				returnArray = (ArrayList<HashMap<Object, Object>>) method.invoke(obj, methodParam);
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		return returnArray;
	}
	@RequestMapping("/html")
	public @ResponseBody String htmlReturn(HttpServletRequest httpServletRequest) {
		String html     = httpServletRequest.getParameter("html");
		String template = httpServletRequest.getParameter("template");
		String action   = httpServletRequest.getParameter("action");
		String contents = httpServletRequest.getParameter("contents");
		StringBuffer fileContents = new StringBuffer();

		FileSelect sct = new FileSelect();
		if(action == null || action.equals("")){
			fileContents = sct.fileRead(html, template ,httpServletRequest);
		}else if(action.equals("save")){
			fileContents = sct.fileWrite(html, template, httpServletRequest , contents);
		}else if(action.equals("apply")){
			fileContents = sct.fileApply(html, template, httpServletRequest , contents);
		}
		return fileContents.toString();
	}
}
