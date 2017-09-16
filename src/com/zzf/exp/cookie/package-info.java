/**
 * 处理cookies:Servlet Cookie 处理需要对中文进行编码与解码，方法如下：
String   str   =   java.net.URLEncoder.encode("中文"，"UTF-8");            //编码
String   str   =   java.net.URLDecoder.decode("编码后的字符串","UTF-8");   // 解码
 */
/**
 * @author zzf
 *
 */
package com.zzf.exp.cookie;