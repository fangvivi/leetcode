package com.wayne;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.cn/problems/valid-parentheses/
 *
 * @author wayne
 */
public class ValidParentheses {
    public static void main(String[] args) {
        ValidParentheses validParentheses = new ValidParentheses();
        String s = "((";
        System.out.println(validParentheses.isValidA(s));
    }

    public boolean isValid(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        try {
            return check(s);
        } catch (Exception e) {
            return false;
        }

    }

    private boolean check(String s) {
        Deque<Character> parenthesesStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            switch (c) {
                case '(':
                    parenthesesStack.push(c);
                    break;
                case ')':
                    char pop = parenthesesStack.pop();
                    if (pop != '(') {
                        return false;
                    }
                    break;
                case '[':
                    parenthesesStack.push(c);
                    break;
                case ']':
                    pop = parenthesesStack.pop();
                    if (pop != '[') {
                        return false;
                    }
                    break;
                case '{':
                    parenthesesStack.push(c);
                    break;
                case '}':
                    pop = parenthesesStack.pop();
                    if (pop != '{') {
                        return false;
                    }
                    break;
                default:
                    return false;
            }
        }
        return parenthesesStack.isEmpty();
    }

    /**
     * 上面代码的简化版，性能并不比上边好多少
     */
    public boolean isValidA(String s) {
        if (s.length() % 2 != 0) {
            return false;
        }
        Map<Character, Character> map = new HashMap<>(3);
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        Deque<Character> parenthesesStack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (map.containsKey(c)) {
                // 如果是右半括号，根据右半括号获取左半括号并和栈顶元素进行对比
                if (parenthesesStack.isEmpty()
                        || !parenthesesStack.pop().equals(map.get(c))) {
                    return false;
                }
            } else {
                // 如果当前字符不是map的key，肯定是左半括号，左半括号入栈
                parenthesesStack.push(c);
            }
        }
        return parenthesesStack.isEmpty();
    }
}
