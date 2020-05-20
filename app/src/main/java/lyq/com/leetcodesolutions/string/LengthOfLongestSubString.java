package lyq.com.leetcodesolutions.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @author sunshiny
 * @date 2020-05-18.
 * @desc
 *
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 */
public class LengthOfLongestSubString {

    public static void main(String[] args){
        System.out.println(lengthOfLongestSubString("aaaa"));
    }

    /**
     * 伪代码：使用滑动窗口的方式，使用hashSet数据结构来判断是否含有重复字符串
     *  1. 首先记录当前滑动窗口的左右指针
     *  2. 如果满足下一个元素与当前窗口里面的元素不重复，那么右指针++，将元素加入到集合中
     *  3. 如果元素重复了，那么就需要计算出当前最大无重复的字符串
     *  4. 左指针向右移动一个，并且将元素删除
     *
     *  滑动窗口！！！以及数据结构
     */
    public static int lengthOfLongestSubString(String s){
        Set<Character> res = new HashSet<>();
        int ans = 0;
        int rk = -1, n = s.length();

        for(int i = 0; i < n ; ++i){
            if (i != 0 ){
                res.remove(s.charAt(i-1));
            }

            while(rk + 1 < n && !res.contains(s.charAt(rk + 1))){
                res.add(s.charAt(++rk));
            }

            ans = Math.max(ans,rk-i+1);
        }

        return ans;

    }

}
