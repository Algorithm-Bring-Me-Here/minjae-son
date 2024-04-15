// 예상 대진표

class Solution {
    fun solution(n: Int, a: Int, b: Int): Int {
        var answer = 0
        var participant = a
        var competitor = b

        while (participant != competitor) {
            participant = (participant+1) / 2
            competitor = (competitor+1) / 2
            answer++
        }
        return answer
    }
}