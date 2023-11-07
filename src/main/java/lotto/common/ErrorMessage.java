package lotto.common;

public enum ErrorMessage {
    LOTTO_NUMBER_OVER_SIZE("[ERROR] 로또 번호의 개수는 6개입니다.\n"),
    LOTTO_NUMBER_DUPLICATED("[ERROR] 로또 번호: 중복되면 안 됩니다.\n"),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호: 1~45 숫자만 가능합니다.\n"),

    INPUT_AMOUNT_NOT_NUMERIC("[ERROR] 구입 금액은 숫자만 입력 가능합니다.\n"),
    INPUT_AMOUNT_INVALID_UNIT("[ERROR] 잘못된 구입 금액 단위입니다.\n");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }

    public static void printExceptionMessage(Exception e) {
        System.out.print(e.getMessage());
    }

}
