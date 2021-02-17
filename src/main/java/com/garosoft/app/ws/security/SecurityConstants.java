package com.garosoft.app.ws.security;

public class SecurityConstants {
	public static final long EXPIRATION_TIME=864000000;//10 DAYS MLSECONDS
	public static final String TOKEN_PREFIX="Bearer ";
	public static final String HEADER_STRING="Authorization";
	public static final String SIGN_UP_URL= "/alumnos";
	public static final String TOKEN_SECRET="jf9i4jgu83nf10";
	public static String getTokenSecret() {
		return TOKEN_SECRET;
	}


}
