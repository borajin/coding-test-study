### 틀린답
이분탐색을 생각하지 못하고 배열을 만들어 정렬해서 풀었음 → 메모리초과

메모리 초과 이유: N은 $10^5$보다 작거나 같은 자연수

$10^5$ x $10^5$를 하게 되면 엄청 많은 메모리가 필요하기 때문
```java
Scanner sc = new Scanner(System.in);

int N = sc.nextInt();
int K = sc.nextInt();

int b[] = new int[N*N];

for (int i=0; i<N; i++) {
  for (int j=i; j<N; j++) {
    b[j*N+i] = b[i*N+j] = (i+1) * (j+1);
  }
}

Arrays.sort(b);
System.out.println(b[K-1]);
```
### 이진탐색 사용
B[K] = x ⇒ x보다 크거나 작은 수가 K개 있다

x값을 조정해 나가면서 x보다 작거나 같은 원소의 개수가 K와 일치하면 됨

임의의 수 a보다 작거나 같은 개수가 K보다 작으면 x는 a보다 큰 수이고,

K보다 크면 x는 a보다 작은 수라는 것을 알 수 있음

ex) N=3일때, B의배열 = {1 2 2 3 3 4 6 6 9}

x=4, x보다 작거나 같은 원소 개수(=K): 6개

a=3, a보다 작거나 같은 원소 개수: 5개

a=6,a보다 작거나 같은 원소 개수: 8개
```java
Scanner sc = new Scanner(System.in);

int N = sc.nextInt();
int K = sc.nextInt();

int lo = 0;
int hi = K;	//마지막 값이 K인 이유: i*j 배열에 K번째 수보다 큰 수는 필요 없음
while (lo < hi) {
    int mid = (lo + hi) / 2;	//B[K] = x일 때 x값
    int count = 0;

    //min(mid/i, N)인 이유
    //배열에 들어가는 값이 i*1, i*2 ... i*j로 한 행의 열의 개수를 넘지 않기 때문
    for (int i=1; i<=N; i++) {
      count += Math.min(mid/i, N);  //x보다 작거나 같은 개수
    }

    if (count < K)
      lo = mid + 1;
    else
      hi = mid;
}

System.out.println(hi);
```
count가 K이상일 때, 배열B에 대해 인덱스를 큰쪽에서 작은 쪽으로 줄임. 배열에는 똑같은 값이 여러개 있을 수 있기 때문에 이분탐색으로 count==K인 경우를 찾지 못할 수 있음

→ 동일한 값을 포함하고 있기때문에 정확한 인덱스는 찾지 못해도 B[k]의 값은 보장할 수 있음

N=3, K=7일 때, count가 8로 탐색이 종료 되었어도 B[7]=6, B[8]=6이기 때문에 정답 6이 되는 것
