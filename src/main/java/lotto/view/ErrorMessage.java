package lotto.view;

public final class ErrorMessage {
    public static void lengthError(int length) {
        System.out.printf("[ERROR] 입력 값의 개수는 %d개 여야 합니다.\n", length);
    }

    public static void duplicationListError() {
        System.out.printf("[ERROR] 입력 값들은 서로 중복되지 않아야 합니다.\n");
    }

    public static void numberInRangeError(int min, int max) {
        System.out.printf("[ERROR] 입력 값의 범위는 %d부터 %d 사이의 숫자여야 합니다.\n",min,max);
    }

    public static void stringToIntegerError() {
        System.out.printf("[ERROR] 입력 값은 숫자여만 합니다.\n");
    }
    public static void multipleNumberError(int divisor) {
        System.out.printf("[ERROR] 입력 값은 %d원 단위여만 합니다.\n", divisor);
    }
    public static void validateCertainNumberDuplicateInList(){
        System.out.printf("[ERROR] 입력 값이 리스트안의 값고 중복되면 않됩니다.\n");
    }
}
