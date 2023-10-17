import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

        int[] arr1 = {3, 2, 7, 2};
        int[] arr2 = {4, 6, 5, 1};


        System.out.println(solution(arr1, arr2));

    }

    public static long solution(int[] queue1, int[] queue2) {
        int answer = -2;

        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        long temp1 = sum1;

        System.out.println(sum1 + ", " + sum2);

        long sum = sum1 + sum2;

        if (sum % 2 == 1) {
            answer = -1;
        }

        long ave = sum / 2;

        LinkedListQueue<Integer> q1 = new LinkedListQueue<>();
        LinkedListQueue<Integer> q2 = new LinkedListQueue<>();

        for (int element : queue1) {
            q1.enqueue(element);
        }

        for (int element : queue2) {
            q2.enqueue(element);
        }

        long move = 0L;

        while (temp1 != ave) {
            System.out.println("====");
            int x = 0;

            if (temp1 < ave) {
                if (!q2.isEmpty()) {
                    x = q2.dequeue();
                    q1.enqueue(x);


                    temp1 += x;
                    System.out.println("원소:" + x);
                    System.out.println("합1 "+ temp1);
                    System.out.println("--");
                    q1.printAll();
                    move++;
                } else {
                    answer = -1;
                    break;
                }
            } else {
                if (!q1.isEmpty()) {
                    x = q1.dequeue();

                    q2.enqueue(x);
                    temp1 -= x;
                    System.out.println("원소:" + x);
                    System.out.println("합1 "+ temp1);
                    System.out.println("--");
                    move++;
                } else {
                    answer = -1;
                    break;
                }
            }
        }





        System.out.println();

        return move;
    }

    public static class LinkedListQueue<T> {
        private LinkedList<T> list = new LinkedList<T>();

        // 큐의 끝에 요소를 추가하는 메서드 (enqueue)
        public void enqueue(T item) {
            list.addLast(item);
        }

        // 큐의 앞에서 요소를 제거하고 반환하는 메서드 (dequeue)
        public T dequeue() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return list.removeFirst();
        }

        // 큐가 비어 있는지 확인하는 메서드
        public boolean isEmpty() {
            return list.isEmpty();
        }

        // 큐의 크기를 반환하는 메서드
        public int size() {
            return list.size();
        }

        // 큐의 첫 번째 요소를 반환하는 메서드 (peek)
        public T peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Queue is empty");
            }
            return list.getFirst();
        }

        public void printAll() {
            for (T item : list) {
                System.out.print(item + " ");
            }
            System.out.println();
        }

    }
}