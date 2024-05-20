class Solution {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostSet = lost.toSet()
        val reserveSet = reserve.toSet()

        // 체육복을 도난당한 학생 중 여벌 체육복이 있는 학생 찾기
        var realLost = (lostSet - reserveSet).toList().sorted()
        var realReserve = (reserveSet - lostSet).toList().sorted()

        // 바로 앞이나 뒷 사람에게 체육복 빌리기
        realLost.forEach { student ->
            if (student > 1 && student - 1 in realReserve) {
                realReserve -= (student - 1)
                realLost -= student
            } else if (student < n && student + 1 in realReserve) {
                realReserve -= (student + 1)
                realLost -= student
            }
        }

        val answer = n - realLost.size
        return answer
    }
}