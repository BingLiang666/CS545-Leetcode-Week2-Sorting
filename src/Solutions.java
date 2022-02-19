import java.util.ArrayList;
import java.util.List;

public class Solutions {

    /* Problem 215. #Kth Largest Element in an Array# #MEDIUM#
     * https://leetcode.com/problems/kth-largest-element-in-an-array/
     *  Problem description:
     *  Given an integer array nums and an integer k, return the kth largest element in the array.
     *  Note that it is the kth largest element in the sorted order, not the kth distinct element.
     */

    public static int findKthLargest(int[] nums, int k) {
        if (nums.length == 0 || k <= 0) return -1;
        mergeSort(nums, 0, nums.length - 1);
        return nums[k - 1];
    }

    private static void mergeSort(int[] nums, int low, int high) {
        if (low >= high) return;
        int mid = (low + high) / 2;
        mergeSort(nums, low, mid);
        mergeSort(nums, mid + 1, high);
        mergeTwoSortedChunks(nums, low, high);
    }

    private static void mergeTwoSortedChunks(int[] nums, int low, int high) {
        int[] temp = new int[high - low + 1];
        int mid = (low + high) / 2;
        int i = low;
        int j = mid + 1;
        int index = 0;
        while (i <= mid || j <= high) {
            if (i > mid) {
                temp[index++] = nums[j++];
            } else if (j > high) {
                temp[index++] = nums[i++];
            } else {
                if (nums[i] > nums[j]) {
                    temp[index++] = nums[i++];
                } else {
                    temp[index++] = nums[j++];
                }
            }
        }
        for (int pos = index - 1; pos >= 0; pos--) {
            nums[high--] = temp[pos];
        }
    }

    /* Problem 229. #Majority Element II# #MEDIUM#
     * https://leetcode.com/problems/majority-element-ii/
     *  Problem description:
     *  Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
     */
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList();
        if (nums.length == 0) {
            return res;
        }
        if (nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        mergeSort(nums, 0, nums.length - 1);
        int leastFreq = nums.length / 3;
        int prev = nums[0];
        int curFreq = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == prev) {
                curFreq++;
            } else {
                if (curFreq > leastFreq) {
                    res.add(prev);
                }
                prev = nums[i];
                curFreq = 1;
            }
            if (i == nums.length - 1) {
                if (curFreq > leastFreq) {
                    res.add(prev);
                }
            }
        }
        return res;
    }
}
