package com.example.seckill.utils;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MD5Util {

    /**
     * md5方法
     *
     * @param str
     * @return
     */
    public static String md5(String str) {
        return DigestUtils.md5Hex(str);
    }


    private static final String salt = "1a2b3c4d";

    /**
     * 前端md5
     *
     * @param str
     * @return
     */
    public static String frontToBackPass(String str) {
        String md51 = salt.charAt(1) + salt.charAt(3) + str + salt.charAt(5) + salt.charAt(3);
        return md5(md51);
    }

    /**
     * 后端到数据库Md5
     *
     * @param str
     * @param salt
     * @return
     */
    public static String backToDBPass(String str, String salt) {
        String md51 = salt.charAt(1) + salt.charAt(3) + str + salt.charAt(5) + salt.charAt(3);
        return md5(md51);
    }

    /**
     * 前端都数据库MD5
     *
     * @param str
     * @param salt
     * @return
     */
    public static String frontToDb(String str, String salt) {
        return backToDBPass(frontToBackPass(str), salt);
    }

}
