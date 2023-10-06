package leetcode

import java.util.*

class HtmlParser {
    fun getUrls(url: String): List<String> {
        return listOf()
    }
}

fun crawl(startUrl: String, htmlParser: HtmlParser): List<String> {
    val visited = mutableMapOf<String, Boolean>()
    val crawlerResult = mutableListOf<String>()
    val queue = LinkedList<String>()
    visited[startUrl] = true
    queue.addLast(startUrl)
    while (queue.isNotEmpty()) {
        val top = queue.removeFirst()
        val domain = top.removePrefix("http://").split("/").first()
        crawlerResult.add(top)
        val urls = htmlParser.getUrls(top)
        if (urls.isNotEmpty()) {
            urls.forEach { url ->
                val urlDomain = url.removePrefix("http://").split("/").first()
                if (!visited.containsKey(url) && domain == urlDomain)  {
                    visited[url] = true
                    queue.addLast(url)
                }
            }
        }
    }
    return crawlerResult
}