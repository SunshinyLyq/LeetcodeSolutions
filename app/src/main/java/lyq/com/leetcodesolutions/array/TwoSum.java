package lyq.com.leetcodesolutions.array;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        //使用hashMap,需要额外的空间，但是时间复杂度为O（N）
        Map<Integer,Integer> map = new HashMap<Integer,Integer>();
        for(int i = 0; i < nums.length;i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }

        throw new IllegalArgumentException("no sum target");
    }

    //不需要额外空间，那就是暴力法 n的平方， 空间为O（1）
    public  int[] twoSum2(int[] nums, int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target){
                    return new int[]{i,j};
                }
            }
        }
        throw  new IllegalArgumentException("no sum target");
    }
}
