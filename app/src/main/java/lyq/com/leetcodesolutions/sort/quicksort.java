package lyq.com.leetcodesolutions.sort;

/**
 * @author sunshiny
 * @date 2020-05-16.
 * @desc
 *
 * 快速排序
 * 分治法： 找到基准值，将数组分下去，逐个比较
 * 时间复杂度最好的情况下，都是中位数，中分，时间复杂度为T（n） = 2* T(n/2) + O(n)
 * 这个O(n)是与基准值进行比较所花费的时间复杂度
 * 分层，O（logN）,每层都需要比较，NO(logN)
 * 最坏情况下，就是每次选择的基准值当前这个数组的最大值或者最小值，就是跟冒泡。O（N2）;
 */
public class quicksort {
}
