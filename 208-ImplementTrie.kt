package leetcode

class Trie() {
    data class TrieNode(var isWord: Boolean = false, val children: MutableList<TrieNode?> = MutableList(26) { null })
    val root = TrieNode()
    fun insert(word: String) {
        var curr = root
        word.forEach { ch ->
            val index = ch - 'a'
            if (curr.children[index] == null) curr.children[index] = TrieNode()
            curr = curr.children[index]!!
        }
        curr.isWord = true
    }

    fun search(word: String): Boolean {
        var curr = root
        word.forEach { ch ->
            val index = ch - 'a'
            if (curr.children[index] == null) return false
            curr = curr.children[index]!!
        }
        return curr.isWord
    }

    fun startsWith(prefix: String): Boolean {
        var curr = root
        prefix.forEach { ch ->
            val index = ch - 'a'
            if (curr.children[index] == null) return false
            curr = curr.children[index]!!
        }
        return true
    }
}