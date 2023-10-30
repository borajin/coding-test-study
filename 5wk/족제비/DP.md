### DP (Dynamic Programming) 란?

크고 복잡한 문제를 작은 문제들로 나누어 해결하는 알고리즘.

**유사한 알고리즘들과의 차이**

- 분할정복 : 단순히 큰 문제를 작은 문제로 나눠서 해결
- 그리디 : 각 단계에서의 최선의 선택을 통해 해를 찾음
- 동적 프로그래밍 : 중복 계산을 피하기 위해 작은 문제의 답을 활용하여 전체 문제를 해결

### DP 를 활용할 수 있는 문제의 특징

**최적 부분 구조**

- 큰 문제를 작은 문제로 쪼갤 수 있고, 작은 문제의 답들로 전체 문제의 최적해를 구할 수 있다.

**중복 부분 문제**

- 동일하게 반복되는 작은 문제들이 있어, 이 중복을 피하기 위해 계산된 결과를 재사용함.

### DP의 방식

**상향식 접근 (Bottom-Up)**

- 작은 문제부터 시작해 이를 조합해 전체 문제를 해결 (이전에 계산한 작은 결과의 답을 조합)
- 주로 반복문을 이용
- 직관적임. 재귀 호출의 스택 오버플로우 가능성이 없어 메모리 사용량이 적고 실행 시간이 빠를 수 있음.

**하향식 접근 (Top-Down)**

- 큰 문제를 해결하기 위해 재귀적으로 작은 문제부터 해결
- 메모이제이션(Memoization) 기법을 활용해 중간 결과를 저장하여 중복 계산을 피함.
- 재귀적 구조의 문제 파악에 용이하며 중복 계산을 피할 수 있어 중복 부분 문제가 있는 경우 유용함.

### 피보나치 수열의 구현 방식

**단순 재귀 vs 탑다운**

```java
public int fibonacci(int n) {
	if(n == 1 || n == 2) { 
		return 1;
	}
	
	return fibonacci(n-1) + fibonacci(n-2);
}
```

단순 재귀로 구현하면 

…

fibonacci(4) = fibonacci(3) + **fibonacci(2)**

→ fibonacci(3) = **fibonacci(2)** + fibonacci(1)

위처럼 같은 부분 문제가 중복해서 계산되어 시간 복잡도가 커지게 된다.

DP에서는 이런 중복 문제를 해결하기 위해 이전 계산 결과를 재활용한다.

```java
...

HashMap<Integer, Integer> memo = new HashMap<>();

...

public int fibonacci(int n) {
	if(n == 1 || n == 2) { 
		return 1;
	}

	//계산된 적 없으면 기억하기
	if(!memo.containsKey(n)) {
		memo.put(n, fibonacci(n-1) + fibonacci(n-2));
	}
	
	return memo.get(n);   //한번 계산된 결과는 다시 계산하지 않음.
}
```

**바텀 업**

```java
public int fibonacci(int n) {
	int[] fibonacciArray = new int[n + 1];
	fibonacciArray [0] = 0;
  fibonacciArray [1] = 1;

  for (int i = 2; i <= n; i++) {
	  fibonacciArray[i] = fibonacciArray[i - 1] + fibonacciArray[i - 2]; //이전에 계산한 작은 결과의 답을 조합
  }

  return fibonacciArray[n];
}
```
