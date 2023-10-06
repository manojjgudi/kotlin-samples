package leetcode

fun findPeakElement(nums: IntArray): Int {
    val n = nums.size
    if (n == 1) return 0
    if (nums[0] > nums[1]) return 1
    if (nums[n - 1] > nums[n - 2]) return n - 1
    var start = 1
    var end = n - 2
    while (start <= end) {
        val mid = start + (end - start) / 2
        if (nums[mid] > nums[mid - 1] && nums[mid] > nums[mid + 1]) return mid
        else if (nums[mid] < nums[mid - 1]) end = mid - 1
        else start = mid + 1
    }
    return -1
}