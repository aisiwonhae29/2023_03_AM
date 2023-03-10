package com.KoreaIT.java.AM;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Datefx {
	/** 날짜 함수 */
	public static String getNowDateTimeStr() {
		LocalDateTime now = LocalDateTime.now();
		String formatedNow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));

		return formatedNow;
	}
}
