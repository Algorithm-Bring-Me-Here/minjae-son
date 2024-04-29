// 로또 최고순위 , 최저순위

class Solution {
    fun solution(lottos: IntArray, win_nums: IntArray): IntArray {
        lateinit var answer: IntArray
        var count = 0       // 0의 개수
        var correctnum = 0  // 현재 맞은 번호의 개수
        
        for (lotto in lottos) {
            if (lotto == 0)
                count++
            else if (lotto in win_nums)
                correctnum++
        }
        
        val maxcorrect = correctnum + count
        val mincorrect = correctnum
        
        val maxprize = getPrize(maxcorrect)
        val minprize = getPrize(mincorrect)
        
        answer = intArrayOf(maxprize, minprize)
        return answer
    }
    
    fun getPrize(corrects: Int) : Int {
        return when (corrects) {
            6 -> 1
            5 -> 2
            4 -> 3
            3 -> 4
            2 -> 5
            1 -> 6
            0 -> 6
            else -> throw IllegalArgumentException("해당 순위가 존재하지 않습니다.")
        } 
    }
}