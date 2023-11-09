public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N 입력
        int N = Integer.parseInt(br.readLine());

        int[] cards = new int[N];

        // 숫자 카드 입력
        st = new StringTokenizer(br.readLine());

        // 배열에 할당
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(cards);

        // 구해야 할 숫자 개수 M 입력
        int M = Integer.parseInt(br.readLine());

        int[] finds = new int[M];

        // 숫자들 입력
        st = new StringTokenizer(br.readLine());

        // 배열에 할당
        for (int i = 0; i < M; i++) {
            finds[i] = Integer.parseInt(st.nextToken());
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();

        for (int f : finds) {
            int count = binarySearch(cards, f);
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }

    public static int binarySearch(int[] cards, int target) {
        int left = 0;
        int right = cards.length - 1;
        int count = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (cards[mid] == target) {
                // 타겟과 중간값 일치시 중복값++
                count++;

                // 좌우로 확장해서 카운트
                int li = mid - 1;
                int ri = mid + 1;

                // 배열의 첫번째 값 이전으로 넘어갈 수 없음
                while (li >= 0 && cards[li] == target) {
                    count++;
                    li--;
                }

                // 배열의 마지막 값 이후로 넘어갈 수 없음
                while (ri < cards.length && cards[ri] == target) {
                    count++;
                    ri++;
                }

                return count;

            } else if (cards[mid] < target) { // 중간 값이 타겟보다 작으면 타겟은 배열 오른쪽에
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return count;
    }
}
