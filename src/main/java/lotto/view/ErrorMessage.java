package lotto.view;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static void divideNumberError(int divisor) {
        System.out.printf("[ERROR] %d(으)로 나누어 지지 않습니다.", divisor);
    }
}
