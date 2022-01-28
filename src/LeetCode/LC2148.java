package LeetCode;

public class LC2148 {
    public int countElements(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) return 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, minCount = 0, maxCount = 0;
        for (int i = 0; i < len; i++) {
            min = Math.min(nums[i], min);
            max = Math.max(nums[i], max);
        }
        for (int i = 0; i < len; i++) {
            if (min == nums[i]) minCount++;
            if (max == nums[i]) maxCount++;
        }
        if(max == min) return 0;
        return len - minCount - maxCount;
    }

//    public int countElements(int[] nums) {
//        int len = nums.length;
//        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, count = 0;
//        for (int i = 0; i < len; i++) {
//            min = Math.min(nums[i], min);
//            max = Math.max(nums[i], max);
//        }
//        for (int i = 0; i < len; i++) {
//            if (min < nums[i] && max > nums[i]) count++;
//        }
//        return count;
//    }
}
