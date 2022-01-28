package LeetCode.DFS_BFS;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/*433. Minimum Genetic Mutation -BFS*/
public class LC433 {
    public int minMutation(String start, String end, String[] bank) {
        /*起始基因序列*/
        Set<String> st = new HashSet<>();
        st.add(start);
        /*目标基因序列*/
        Set<String> ed = new HashSet<>();
        ed.add(end);
        /*基因库*/
        Set<String> dict = new HashSet<>(Arrays.asList(bank));
        /*基因变化过程*/
        Set<String> mem = new HashSet<>();
        //基因库中不存在目标基因序列
        if (!dict.contains(end)) {
            return -1;
        }
        return bfs(st, ed, mem, dict, 0);
    }

    public int bfs(Set<String> st, Set<String> ed, Set<String> mem, Set<String> dict, int len) {
        if (st.size() == 0) {
            return -1;
        }
        Set<String> next = new HashSet<>();
        char[] list = new char[]{'A', 'C', 'G', 'T'};
        for (String s : st) {
            StringBuilder sb = new StringBuilder(s);
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 4; j++) {
                    sb.setCharAt(i, list[j]);
                    String gene = sb.toString();
                    if (ed.contains(gene)) {
                        return len + 1;
                    }
                    if (mem.contains(gene)) {
                        continue;
                    }
                    if (dict.contains(gene)) {
                        next.add(gene);
                        mem.add(gene);
                    }
                    sb.setCharAt(i, s.charAt(i));

                }
            }
        }
        return bfs(next, ed, mem, dict, len + 1);

    }
}
