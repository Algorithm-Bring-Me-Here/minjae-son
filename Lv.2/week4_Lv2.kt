class Solution {
    fun solution(clothes: Array<Array<String>>): Int {
        val counts = countClothesByType(clothes)
        val answer = calculateAnswer(counts)
        return answer
    }

    fun countClothesByType(clothes: Array<Array<String>>): Map<String, Int> {
        val counts = mutableMapOf<String, Int>()
        for (cloth in clothes) {
            val type = cloth.last()
            counts[type] = counts.getOrDefault(type, 0) + 1
        }
        return counts
    }

    fun calculateAnswer(counts: Map<String, Int>): Int {
        var answer = 1
        for (count in counts.values) {
            answer *= (count+1)
        }
        return answer-1
    }
}