// 타겟 넘버 (깊이 우선 탐색 이용)

class Solution {

	  fun solution(numbers: IntArray, target: Int): Int { 
        return dfs(numbers, target, 0, 0)
    }
    
    fun dfs(numbers: IntArray, target: Int, index: Int, sum: Int): Int { // 깊이 우선 탐색
	    if (index == numbers.size) { // 리프 노드 도착 시 최종 결과값 검사 
	        return if (sum == target) 1 else 0 
	    } else {
	        val num = numbers[index] 
	        val add = dfs(numbers, target, index + 1, sum + num) // 다음 원소를 더하는 경우
	        val subtract = dfs(numbers, target, index + 1, sum - num) // 다음 원소를 빼는 경우
	        return add + subtract
		    }
		}
}