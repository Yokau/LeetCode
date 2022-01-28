package LeetCode.DFS_BFS;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LC17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        StringBuffer str = new StringBuffer();
        if (digits.equals(""))
            return res;
            Map<Character, String> map = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        dfs(res, 0, digits, map, str);
        return res;
    }

    public void dfs(List<String> res, Integer index, String digits, Map<Character, String> map, StringBuffer str) {
        if(index == digits.length()) {
            res.add(str.toString());
        }else {
            Character num = digits.charAt(index);  //'2'
            String letters = map.get(num);          //"abc"
            int len = letters.length();         //'3'
            for (int i = 0; i < len; i++){
                str.append(letters.charAt(i));
                dfs(res, index + 1, digits, map, str);
                str.deleteCharAt(str.length()-1);
            }
        }
    }
}
