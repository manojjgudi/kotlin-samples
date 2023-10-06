package leetcode

fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
    fun combinationSum(
        candidates: IntArray,
        target: Int,
        index: Int,
        list: MutableList<Int>,
        combinationSumList: MutableList<List<Int>>
    ) {
        if (target == 0) {
            combinationSumList.add(list.sorted())
        }
        if (index >= candidates.size || target < 0) {
            return
        }
        list.add(candidates[index])
        combinationSum(candidates, target - candidates[index], index, list, combinationSumList)
        list.remove(candidates[index])
        combinationSum(candidates, target, index + 1, list, combinationSumList)
    }

    val res = mutableListOf<List<Int>>()
    combinationSum(candidates, target, 0, mutableListOf<Int>(), res)
    return res.toSet().toList()
}