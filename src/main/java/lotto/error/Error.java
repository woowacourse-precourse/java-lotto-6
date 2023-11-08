package lotto.error;

public class Error {
    public enum ErrorType {
        INVALID_MONEY_TYPE("[ERROR] 유효하지 않은 값입니다."),
        INVALID_MONEY_VALUE("[ERROR] 1000이상이며, 1000으로 나누어 떨어지는 값을 입력해 주세요."),

        INVALID_LOTTO_SIZE("[ERROR] 로또 숫자는 6개를 입력해야 합니다."),
        INVALID_LOTTO_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
        DUPLICATION("[ERROR] 중복된 숫자가 있으면 안됩니다."),
        INVALID_LOTTO_INPUT("[ERROR] 유효하지 않은 값입니다."),
        ;

        private final String message;

        ErrorType(String message) {
            this.message = message;
        }

        public String getMessage() {
            return this.message;
        }
    }

    public static void showErrorMessage(ErrorType errorType) {
        System.out.println(errorType.message);
    }
}
