package lyq.com.leetcodesolutions.array;

/**
 * @author sunshiny
 * @date 2020-05-19.
 * @desc
 * LeetCode 39 数组中出现次数超过一半的数字
 *
 */
public class majorityElement {
    public static void main(String[] main){
        System.out.println(majorityElement(new int[]{1,2,1,1,1,2,2,4,2}));
    }

    public static int majorityElement(int[] elements){
        int target = elements[0];
        int count = 1;
        for (int i = 0; i < elements.length; i++) {
            if (target == elements[i]){
                count++;
            }else {
                count --;
            }

            if (count == 0){
                target = elements[i];
                count = 1;
            }
        }

        return target;
    }
}
