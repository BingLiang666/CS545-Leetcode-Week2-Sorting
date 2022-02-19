import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.Arrays;
import java.util.List;

class SolutionsTest {
    Solutions solutions;
    public int[] nums1, nums2, nums3, nums4, nums5, nums6, nums7, nums8;
    List<Integer> res;

    @BeforeEach
    void setUp() {
        solutions = new Solutions();
        nums1 = new int[] {2, 2, 1, 0, 0, 0, 2, 1, 2, 0, 0};
        nums2 = new int[] {0, 0, 0, 0, 0, 1, 1, 2, 2, 2, 2};
        nums3 = new int[] {2, 5, 10, 123, 0, 0, 0, 0, 0};
        nums4 = new int[] {3, 2};
        nums5 = new int[] {1, 2, 3, 5, 8, 10, 14, 100, 123};
        nums6 = new int[] {12, 7, 15, 5, 9, 17, 4, 3, 1, 19, 5, 27};
        nums7 = new int[] {2, 1, 0, 1};
        nums8 = new int[] {1, 2, 19, 100, 22, 81, 83};
    }

    @Test
    void findKthLargest() {
        int res = solutions.findKthLargest(nums6, 3);
        System.out.println(Arrays.toString(nums6));
        assertEquals(res, 17);
    }

    @Test
    void majorityElement() {
        res = solutions.majorityElement(nums4);
        System.out.println(Arrays.toString(nums4));
        for (int i: res) {
            System.out.println(i);
        }
    }
}