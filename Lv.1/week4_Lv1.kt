class Solution { 
    fun solution(board: Array<IntArray>, moves: IntArray): Int {
        
        var answer = 0 
        val basket = mutableListOf<Int>() // board에서 옮겨온 원소들을 저장할 바구니
        
        // 바구니에 번호 넣기
        for (move in moves) { 
            val lineNum = move - 1 // 이동할 열의 인덱스 계산
            var doll: Int? = null // 뽑은 인형 번호를 저장할 변수
            
            // 해당 열에서 가장 위에 있는 인형 뽑기
            for (i in board.indices) { 
                val currentDoll = board[i][lineNum] // 해당 열의 현재 인형
                if (currentDoll != 0) { // 인형이 있는 경우
                    doll = currentDoll // 해당 인형 뽑기
                    board[i][lineNum] = 0 // 해당 자리는 뽑았으므로 0으로 초기화
                    break
                }
            }
            
            // 바구니에 인형 넣기
            if (doll != null) { // 인형을 뽑은 경우에만 추가
                if (basket.isNotEmpty() && basket.last() == doll) { // 바구니의 마지막 인형과 같은 경우
                    basket.removeAt(basket.size - 1) // 바구니에서 마지막 인형 제거
                    answer += 2 // 제거된 인형은 2개이므로 정답에 추가
                } else {
                    basket.add(doll) // 바구니에 인형 추가
                }
            }
        }
        
        return answer
    }
}