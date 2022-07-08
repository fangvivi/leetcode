package com.wayne;

/**
 * https://leetcode.cn/problems/longest-common-prefix/
 * @author wayne
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] strs = {"dog","dogecar","doga"};
        System.out.println(prefix.longestCommonPrefix(strs));
    }
    public String longestCommonPrefix(String[] strs) {
        // 数组没有元素，直接返回结果
        int arrLength = strs.length;
        if(arrLength == 0){
            return "";
        }
        StringBuilder prefix = new StringBuilder("");
        // 获取最少字符数的字符串，因为公共前缀的最大长度等于最短字符串的长度
        String minLengthStr = strs[0];
        for(int i = 1; i < arrLength; i++ ){
            int length = strs[i].length();
            if(minLengthStr.length() > length){
                minLengthStr = strs[i];
            }
        }
        // 遍历最短字符串的所有字符，和数组中的其他元素的字符进行对比
        for(int i = 0; i < minLengthStr.length(); i++){
            // 字符匹配的次数
            int count = 0;
            char c = minLengthStr.charAt(i);
            for (String str : strs) {
                char c1 = str.charAt(i);
                if (c != c1) {
                    return prefix.toString();
                }
                count++;
            }
            // 如果字符匹配的次数和数组长度一致，表示这个字符属于公共前缀字符
            if(count == arrLength){
                prefix.append(c);
            }
        }
        return prefix.toString();
    }
}
