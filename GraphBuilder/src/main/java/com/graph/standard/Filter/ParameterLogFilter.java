package com.graph.standard.Filter;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;

public class ParameterLogFilter implements Filter {

	protected Logger m_WebLogger = Logger.getLogger( "com.dnt.WebLogger");
	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
			FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub
		HttpServletRequest request = ( HttpServletRequest)servletRequest;
		
		StringBuffer builderLog = new StringBuffer();
	
		builderLog.append( "[REQUEST INFO]\n");
		builderLog.append( "\t{RemoteHost}:{").append( request.getRemoteHost()).append( "}").append( "\n");
		builderLog.append( "\t{Method}:{").append( request.getMethod()).append( "}").append( "\n");
		builderLog.append( "\t{ContentType}:{").append( request.getContentType()).append( "}").append( "\n");
		builderLog.append( "\t{CharSet}:{").append( request.getCharacterEncoding()).append( "}").append( "\n");
		builderLog.append( "\t{AuthType}:{").append( request.getAuthType()).append( "}").append( "\n");
		builderLog.append( "\t{PathInfo}:{").append( request.getPathInfo()).append( "}").append( "\n");
		builderLog.append( "\t{RequestURI}:{").append( request.getRequestURI()).append( "}").append( "\n");
		builderLog.append( "\t{ContextPath}:{").append( request.getContextPath()).append( "}").append( "\n");
		builderLog.append( "\t{QueryString}:{").append( request.getQueryString()).append( "}").append( "\n");
		
		Enumeration<?> e = request.getParameterNames();
		String szParamName = "";
		String szParamValue = "";
		int nParamSeq = 0;

		while( e.hasMoreElements())
		{
			nParamSeq++;
			szParamName = ( String)e.nextElement();
			szParamValue = request.getParameter( szParamName);
			
			builderLog.append( "\t[PARAM").append( nParamSeq).append( "][").append( szParamName).append("=").append( szParamValue).append("]\n");
		}
		
		m_WebLogger.info( builderLog.toString());
		chain.doFilter(servletRequest, servletResponse);
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

}
