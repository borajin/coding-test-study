# 동적 계획법 - Dynamic Programing, 기억하며 풀기
하나의 큰 문제를 작은 문제로 나누어 해결하는 기법 (특정한 알고리즘이 아닌 하나의 문제해결 패러다임)

## 핵심 이론
### 원리와 구현 방식
1. 큰 문제를 작은 문제로 나눌 수 있어야 함 (겹치는 소문제)
2. 작은 문제들이 반복되어 나타나고 이 작은 문제들의 해는 항상 같아야 함 (최적 부분 구조)
3. 모든 작은 문제들의 해는 **DP 테이블**에 저장하여 재사용한다(memoization)
4. 탑-다운방식 혹은 바텀-업 방식으로 구현할 수 있음
  * 탑-다운
    * 위에서부터 문제를 파악해 내려오는 방식
    * 재귀함수로 구현
    * 재귀가 깊을 수록 StackOverFlow 에러 발생 가능성 높아짐
    * 코드 가독성이 좋음
  * 바텀-업
    * 가장 작은 문제부터 큰 문제로까지 확장해나가는 방식
    * 반복문으로 구현
    * 탑-다운에 비해 안전
       
    
#### 피보나치 수열을 동적 계획법으로 풀기
``` D[N] = D[N-1] + D[N-2] ```

1. 동적계획법을 사용 가능한지 확인
   6번째 피보나치 수열은 5번째와 4번째의 합임.
   즉, 6번째 수열을 구하는 문제는 4, 5번째 수열을 구하는 작은 문제로 나눌 수 있고
   수열의 값은 항상 같기 때문에 동적 계획법으로 품
   
3. 점화식 세우기
   논리적으로 전체 문제를 나누고, 전체 문제와 부분 문제 간의 인과 관계 파악
   
5. 메모이제이션 원리 활용
   부분 문제를 풀었을 때 DP 테이블에 저장해두고 다음 같은 부분 문제가 나왔을 때 DP 테이블 값을 이용하는 방법, 메모이제이션으로 5번째 수열의 수는 DP에 저장된 값을 활용
   <img width="733" alt="image" src="https://github.com/borajin/coding-test-study/assets/146801542/e3413c70-6f7e-4129-a44f-ea24fc62bfbe">
   
6A. 탑-다운 구현
  ```
  public class P2747_피보나치수_TopDown {
    static int[] D;
    public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      D = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        D[i] = -1;
      }
      D[0] = 0;
      D[1] = 1;
      fibo(n);
      System.out.println(D[n]);
  }

  static int fibo(int n) {
    if (D[n] != -1) //기존에 계산한 적이 있는 부분 문제는 다시 계산하지 않고 리턴한다.
      return D[n];
    return D[n] = fibo(n - 2) + fibo(n - 1); //메모이제이션 부분
  }
}
```
   
6B. 바텀-업 구현

```
  public class P2747_피보나치수_BottomUp {
    static int[] D;
    public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      int n = sc.nextInt();
      D = new int[n + 1];
      for (int i = 0; i <= n; i++) {
        D[i] = -1;
      }
      D[0] = 0;
      D[1] = 1;
      for (int i = 2; i <= n; i++) {
        D[i] = D[i - 1] + D[i - 2];
      }
      System.out.println(D[n]);
    }
  }
```


### 문제 유형
* 피보나치 수열 계산
* 최장 공통 부분 문자열(LCS) 찾기
* 최단 경로 문제 (예: 다익스트라 알고리즘, 플로이드-와샬 알고리즘)
* 배낭 문제 (Knapsack Problem)
* 그래프 문제 (예: 최대 독립 집합, 최소 비용 신장 트리)

#### 동적계획법 vs 분할정복 
동적계획법 : 작은 문제의 해를 구하고 이를 활용하여 큰 문제의 해를 구하는 것
분할정복 : 단순히 큰 문제를 작은 문제로 나누어 푸는 방법
** 작은 문제의 중복 여부 **
