package pers.hua.oa.utils;

import org.apache.commons.codec.digest.DigestUtils;

public class Md5Utils {
//    public static String md5(String source) {
//        return DigestUtils.md5Hex(source);
//    }

    /**
     * @param source 用户密码
     * @param salt 盐值
     * @return 返回md5加密后的密码
     */
    public static String md5Digest(String source, Integer salt) {
        // 通过toCharArray拿到字符串
        char[] chars = source.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            // 将salt盐值与source源密码 相加 重新赋值给chars
            chars[i] = (char) (chars[i] + salt);
        }
        // 将chars转为字符串
        String target = new String(chars);
        // 通过DigestUtils.md5Hex(元数据) 获取MD5加密值
        String md5 = DigestUtils.md5Hex(target);
        return md5;
    }
}
