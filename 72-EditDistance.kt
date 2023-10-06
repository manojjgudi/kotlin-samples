package leetcode

fun minDistance(word1: String, word2: String): Int {
    val (m, n) = word1.length to word2.length
    val dp = MutableList(m + 1) { MutableList(n + 1) { 0 } }
    repeat(m + 1) { dp[it][0] = it }
    repeat(n + 1) { dp[0][it] = it }
    (1..m).forEach { i ->
        (1..n).forEach { j ->
            if (word1[i - 1] == word2[j - 1]) dp[i][j] = dp[i - 1][j - 1]
            else dp[i][j] = 1 + minOf(dp[i][j - 1], dp[i - 1][j], dp[i - 1][j - 1])
        }
    }
    return dp[m][n]
}