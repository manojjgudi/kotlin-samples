package leetcode

fun numDecodings(s: String): Int {
    val dp = MutableList(s.length + 1) { 0 }
    dp[s.length] = 1
    for (i in s.length - 1 downTo 0) {
        if (s[i] == '0') {
            dp[i] = 0
        } else {
            dp[i] = dp[i + 1]
        }
        if (i + 1 < s.length && (s[i] == '1' || (s[i] == '2' && s[i + 1] < '7'))) {
            dp[i] += dp[i + 2]
        }
    }
    return dp[0]
}