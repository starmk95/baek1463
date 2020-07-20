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
        // D[n] : n을 1로 만들기 위해 사용되는 연산의 횟수
        // 점화식 : D[n] = min(D[n/3], D[n/2], D[n-1]) + 1
        for (int i=2;i<num+1;i++) {
            memo[i] = memo[i-1] + 1; // n-1의 경우
            if (i%2 == 0) { // n/2의 경우
                if (memo[i/2] + 1 < memo[i]) {
                    memo[i] = memo[i/2] + 1;
                }
            }
            if (i%3 == 0) { // n/3의 경우
                if (memo[i/3] + 1 < memo[i]) {
                    memo[i] = memo[i/3] + 1;
                }
            }
        }
        return memo[num];
    }
}
