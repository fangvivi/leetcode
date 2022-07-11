package com.wayne;

/**
 * https://leetcode.cn/problems/longest-common-prefix/
 * @author wayne
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        LongestCommonPrefix prefix = new LongestCommonPrefix();
        String[] strs = {"abc", "ab", "abd"};
        System.out.println(prefix.longestCommonPrefixB(strs));
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

    /**
     * 这个方法是上面那个方法的简化版，思路都是按照顺序纵向匹配所有字符串的字符
     */
    public String longestCommonPrefixA(String[] strs) {
        // 数组没有元素，直接返回结果
        int arrLength = strs.length;
        if(arrLength == 0){
            return "";
        }
        int count = strs[0].length();
        for (int i = 0; i < count; i++) {
            // 遍历字符串的字符
            char c = strs[0].charAt(i);
            for (int j = 1; j < arrLength; j++) {
                // 如果字符的索引值已经到了第一个字符串的长度，后面的字符就不再属于公共前缀
                if(i == strs[j].length() || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }
       return strs[0];
    }

    /**
     * 逐个比较两个元素的公共前缀，再使用公共前缀和后面的元素对比，获取最新的公共前缀
     */
    public String longestCommonPrefixB(String[] strs) {
        // 数组没有元素，直接返回结果
        int arrLength = strs.length;
        if(arrLength == 0){
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < arrLength; i++) {
            prefix = getPrefix(prefix, strs[i]);
            // 如果数组的前两个元素没有公共前缀，就没必要比较后面的元素了
            if(prefix.length() == 0){
                break;
            }
        }
        return prefix;
    }

    private String getPrefix(String str1, String str2){
        int minLength = Math.min(str1.length(), str2.length());
        int index = 0;
        for (int i = 0; i < minLength; i++) {
            if(index < minLength && str1.charAt(i)== str2.charAt(i)){
                index++;
            }
        }
        return str1.substring(0, index);
    }

}
