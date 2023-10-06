package leetcode

class Logger() {
    private val messageMap = mutableMapOf<String, Int>()
    fun shouldPrintMessage(timestamp: Int, message: String): Boolean {
        return if (!messageMap.containsKey(message) || timestamp - messageMap[message]!! >= 10) {
            messageMap[message] = timestamp
            true
        } else false
    }
}