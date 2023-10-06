package leetcode

fun minCost(costs: Array<IntArray>): Int {
    val prev = IntArray(3) { 0 }
    val curr = IntArray(3) { 0 }
    for (cost in costs) {
        curr[0] = cost[0] + minOf(prev[1], prev[2])
        curr[1] = cost[1] + minOf(prev[0], prev[2])
        curr[2] = cost[2] + minOf(prev[0], prev[1])
        repeat(3) { prev[it] = curr[it] }
    }
    return prev.min()
}