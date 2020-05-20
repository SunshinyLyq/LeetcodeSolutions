package lyq.com.leetcodesolutions.array;

import javax.crypto.interfaces.PBEKey;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc
 */
public class FindKthLargest {

    /**
     * leetcode 215 数组中第K个最大元素
     *
     * 思路：仿快排
     */
    public int FindKthLargest(int[] nums,int k){
        int len = nums.length;
        int left = 0;
        int right = len - 1;

        int target = len - k;

        while(true){
            int index = partition(nums,left,right);
            if (index > target){
                right = index-1;
            }else if (index == target){
                return nums[index];
            }else {
                left = index + 1;
            }
        }
    }

    private void swap(int[] nums,int i,int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    //获取基准值
    public int partition(int[] nums,int left,int right){
        int pivot = nums[left];
        int j = left;
        for(int i = left + 1; i < right; i++){
            if(nums[i] < pivot){
                j++;
                swap(nums,i,j);
            }
        }
        swap(nums,j,left);
        return j;
    }
}
