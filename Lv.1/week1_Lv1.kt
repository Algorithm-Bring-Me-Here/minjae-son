// 추억 점수

class Solution {
    fun solution(name: Array<String>,
                 yearning: IntArray,
                 photo: Array<Array<String>>) : IntArray {

        var answer: IntArray = intArrayOf()
        val scoreMap: MutableMap<String,Int> = mutableMapOf()

        for (i in name.indices) {
            scoreMap[name[i]] = yearning[i]
        }

        photo.forEach { picture ->
            var sum = 0
            picture.forEach { name ->
                sum += scoreMap[name]?: 0
            }

            answer = answer.plus(sum)
        }
        return answer
    }
}