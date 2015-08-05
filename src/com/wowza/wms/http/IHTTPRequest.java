package com.wowza.wms.http;

import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public interface IHTTPRequest {

	Map getHeaderMap();

	String getHeader(String arg0);

	int getIntHeader(String arg0);

	Set getHeaderNames();

	/**
	 * Returns the HTTP method of this request, e.g. <code>POST</code>,<code>GET</code>,<code>PUT</code>,<code>DELETE</code>, etc.
	 * @return the HTTP method as string
	 */
	String getMethod();

	String getQueryString();

	int getContentLength();

	String getRequestURI();

	String getRequestURL();

	String getContentType();

	/**
	 * This method is the prerequisite to read out the parameters using {@link #getParameterMap()} or {@link #getParameterNames()} or other methods.
	 * The HTTP request's body is parsed into key-value pairs. It might be a bug, or undocumented feature, but query parameters (appended to the URL with ?param=foo)
	 * are also merged into the body params.
	 * 
	 * E.g. HTTP POST body: <code>foo=bar&foo=baz&baz=boo</code>
	 * 
	 * This parses into this map: <code>{foo -> [bar, baz], baz -> boo}</code>
	 * @param doDecode unclear decoding, most probably %20 is replaced with space
	 */
	void parseBodyForParams(boolean doDecode);

	/**
	 * See {@link #parseBodyForParams(boolean))}
	 */
	void parseBodyForParams();

	String getParameter(String arg0);

	Set getParameterNames();

	String[] getParameterValues(String arg0);

	/**
	 * Returns the parameters of the HTTP request from the body and the query. This can be called after invoking {@link #parseBodyForParams()} or {@link #parseBodyForParams(boolean)}.
	 * 
	 * @return a map keyed with parameter names and for each parameter the {@link List} of values as {@link String}
	 */
	Map getParameterMap();

	java.io.InputStream getInputStream();

	String getProtocol();

	String getScheme();

	String getServerName();

	int getServerPort();

	String getRemoteAddr();

	String getRemoteHost();

	Locale getLocale();

	boolean isSecure();

	String getPath();

	byte[] getHeaderBytes();

	byte[] getMsgBytes();

	boolean isHeadRequest();
	
}
