package lotto.view;

public class ErrorMessage {
    public static void numberInRangeError(int startInclusive, int encInclusive) {
        System.out.printf("[ERROR] 입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다.\n", startInclusive, encInclusive);
    }

    public static void duplicationListError() {
        System.out.printf("[ERROR] 입력 값들은 서로 중복되지 않아야 합니다.\n");
    }

    public static void lengthError(int length) {
        System.out.printf("[ERROR] 입력 값의 개수는 %d개 여야 합니다.\n", length);
    }

    public static void duplicatedNumberInListError() {
        System.out.printf("[ERROR] 입력 값은 앞서 입력한 값들과 중복되지 않아야 합니다.\n");
    }

    public static void inappropriateInput() {
        System.out.printf("[ERROR] 부적절한 입력 값 입니다.\n");
    }
}
