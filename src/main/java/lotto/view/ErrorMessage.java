package lotto.view;

public class ErrorMessage {
    private ErrorMessage() {
    }

    public static void divideNumberError(int divisor) {
        System.out.printf("[ERROR] %d(으)로 나누어 지지 않습니다.\n", divisor);
    }

    public static void listSizeError(int size) {
        System.out.printf("[ERROR] 리스트 길이가 %d이 아닙니다.\n", size);
    }

    public static void listDuplicationError() {
        System.out.print("[ERROR] 리스트에 중복된 숫자가 있습니다.\n");
    }

    public static void numberInListError(int number) {
        System.out.printf("[ERROR] %d(이)가 리스트에 이미 존재 합니다.\n", number);
    }
}
