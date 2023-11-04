package lotto.view;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static void divideNumberError(int divisor) {
        System.out.printf("[ERROR] %d(으)로 나누어 지지 않습니다.", divisor);
    }

    public static void listSizeError(int size) {
        System.out.printf("[ERROR] 리스트 길이가 %d와 일치하지 않습니다.", size);
    }

    public static void listDuplicationError() {
        System.out.print("[ERROR] 리스트에 중복된 숫자가 있습니다.");
    }
}
