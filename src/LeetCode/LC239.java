package LeetCode;

import com.sun.xml.internal.fastinfoset.tools.XML_SAX_StAX_FI;

import java.util.*;

import static java.lang.Integer.MIN_VALUE;

public class LC239 {
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        System.out.println(Arrays.toString(maxSlidingWindow(nums, 3)));
    }
    /*Time out*/
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        int[] max = new int[nums.length - k + 1];
//        Queue<Integer> queue = new LinkedList<>();
//        for (int i = 0; i < nums.length; i++) {
//            queue.add(nums[i]);
//            if(queue.size() >= k){
//                int maxVal = Integer.MIN_VALUE;
//                for (int val : queue) {
//                    maxVal = Math.max(maxVal, val);
//                }
//                max[i - k + 1] = maxVal;
//                queue.poll();
//            }
//        }
//        return max;
//    }

    /*Time out*/
//    public static int[] maxSlidingWindow(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
//        int len = nums.length;
//        int index = 0;
//        int[] res = new int[len - k + 1];
//        for (int i = 0; i < k; i++) {
//            queue.offer(nums[i]);
//        }
//        res[0] = queue.peek();
//        System.out.println(Arrays.toString(res));
//        for (int i = 1; i <= len - k; i++) {
//            queue.remove(nums[index++]);
//            queue.offer(nums[i + k - 1]);
//            res[i] = queue.peek();
//        }
//        return res;
//    }
    public static int[] maxSlidingWindow(int[] nums, int k) {
        LinkedList<Integer> queue = new LinkedList<>();
        int len = nums.length;
        int[] res = new int[len - k + 1];
        int left = 0, right = k - 1;
        for (int i = 0; i < k; i++) {
            if (queue.size() == 0) {
                queue.offer(i);
            }
            else if (nums[queue.getLast()] >= nums[i]) {
                queue.offer(i);
            }
            if (nums[queue.getLast()] < nums[i]) {
                queue.clear();
                queue.offer(i);
            }
        }
        for (int i = 0; i < len - k; i++) {
            if (nums[queue.getLast()] >= nums[i + k]) {
                queue.offer(i + k);
            } else {
                queue.clear();
                queue.offer(i);
            }
            if (queue.getFirst() < i) {
                queue.removeFirst();
            }else{
                res[i] = nums[queue.getFirst()];
            }
        }
        return res;
    }


}
