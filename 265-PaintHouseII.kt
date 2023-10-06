package leetcode

fun minCostII(costs: Array<IntArray>): Int {
    val k = costs[0].size
    val prev = IntArray(k){ 0 }
    val curr = IntArray(k){ 0 }
    for(cost in costs){
        for(i in 0 until k){
            curr[i] = cost[i] + prev.filterIndexed{ index, _ -> index != i }.min()
        }
        repeat(k) { prev[it] = curr[it] }
    }
    return prev.min()
}