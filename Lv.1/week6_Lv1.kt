class Solution {
    fun solution(survey: Array<String>, choices: IntArray): String {
        var answer: String = ""
        val type = charArrayOf('R','T','C','F','J','M','A','N')
        val score = intArrayOf(0,0,0,0,0,0,0,0)
        val personality = mutableMapOf<Char, Int>()
        
        // 초기 매핑
        for (i in type.indices) {
            personality[type[i]] = score[i]
        }
        
        // 각 성격 유형의 점수 부여
        for(i in survey.indices) {
            personality[survey[i][1]] = personality[survey[i][1]]!! + (choices[i]-4) 
        }
        
        // 성격 유형 점수 비교
        for(i in type.indices step 2) {
            if (personality[type[i]]!! >= personality[type[i + 1]]!!) {
                answer += type[i]
            } else {
                answer += type[i + 1]
            }
        }
        return answer
    }
}