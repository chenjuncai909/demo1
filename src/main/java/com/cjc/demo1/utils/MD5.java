package com.cjc.demo1.utils;

import java.security.MessageDigest;
/** 
 * 说明：MD5处理
 * 创建人：cjc
 * 修改时间：2018年3月15日
 *
 */
public class MD5 {

	public static String md5(String str) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(str.getBytes());
			byte[] b = md.digest();

			int i;

			StringBuilder buf = new StringBuilder("");
			for (byte value : b) {
				i = value;
				if (i < 0)
					i += 256;
				if (i < 16)
					buf.append("0");
				buf.append(Integer.toHexString(i));
			}
			str = buf.toString();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return str;
	}
	public static void main(String[] args) {
		System.out.println(md5("31119@qq.com"+"123456"));
		System.out.println(md5("mj1"));
	}
}
