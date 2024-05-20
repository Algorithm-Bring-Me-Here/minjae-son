class Solution {
    fun solution(record: Array<String>): Array<String> {
        val userInfo = mutableMapOf<String, String>() // 유저 아이디와 닉네임을 저장할 맵
        val result = mutableListOf<String>() // 결과 메시지를 저장할 리스트

        // 유저 아이디와 닉네임 맵 만들기
        for (r in record) {
            val parts = r.split(" ")
            if (parts.size < 2) continue // 최소한 두 개의 요소를 포함하지 않으면 건너뛴다
            val action = parts[0]
            val userId = parts[1]
            val nickname = if (action == "Leave") "" else parts[2]
            when (action) {
                "Enter", "Change" -> userInfo[userId] = nickname
            }
        }

        // 결과 생성
        for (r in record) {
            val parts = r.split(" ")
            if (parts.size < 2) continue // 최소한 두 개의 요소를 포함하지 않으면 건너뛴다
            val action = parts[0]
            val userId = parts[1]
            val message = when (action) {
                "Enter" -> "${userInfo[userId]}님이 들어왔습니다."
                "Leave" -> "${userInfo[userId]}님이 나갔습니다."
                else -> continue
            }
            result.add(message)
        }

        // 결과 배열로 변환하여 반환
        return result.toTypedArray()
    }
}