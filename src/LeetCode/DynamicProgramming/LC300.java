package LeetCode.DynamicProgramming;

import java.util.Arrays;

public class LC300 {

    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        int[] pro = new int[len];
        Arrays.fill(pro,1);
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) pro[i] = Math.max(pro[j] + 1, pro[i]);
            }
            res = Math.max(res, pro[i]);
        }
        return res;
    }
}
