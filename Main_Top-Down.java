import java.util.*;

public class Main{
    public static int[] memo; // memorization을 위한 배열

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        memo = new int[num+1];
        memo[0] = 0;
        memo[1] = 0;
        System.out.println(makeOne(num));
    }

    public static int makeOne(int num) {
    	// Top-Down 방식
        // D[n] : n을 1로 만들기 위해 사용되는 연산의 횟수
        // 점화식 : D[n] = min(D[n/3], D[n/2], D[n-1]) + 1
        if (num < 2) { // 예외처리
            return 0;
        }
        int temp; // 연산 최소 횟수 값을 저장할 변수
        if (memo[num-1] == 0) { // 부분 문제가 풀린 적이 없음
            memo[num-1] = makeOne(num-1);
        }
        temp = memo[num-1];
        if (num%2 == 0) { // 2로 나누어떨어지는 경우
            if(memo[num/2] == 0) { // 부분 문제가 풀린 적이 없음
                memo[num/2] = makeOne(num/2);
            }
            if (temp > memo[num/2]) { // 2로 나눈 경우가 연산 횟수가 더 적으면
                temp = memo[num/2];
            }
        }
        if (num%3 == 0) { // 3으로 나누어 떨어지는 경우
            if(memo[num/3] == 0) { // 부분 문제가 풀린 적이 없음
                memo[num/3] = makeOne(num/3);
            }
            if (temp > memo[num/3]) { // 3으로 나눈 경우가 연산 횟수가 더 적으면
                temp = memo[num/3];
            }
        }
        memo[num] = temp+1; // 얻은 연산 횟수 최소값을 저장
        return memo[num];
    }
}
