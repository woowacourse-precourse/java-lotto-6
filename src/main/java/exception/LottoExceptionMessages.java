package exception;

public enum LottoExceptionMessages {
    INVALID_AMOUNT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    NOT_A_NATURAL_NUMBER("[ERROR] 숫자는 자연수여야 합니다."),
    DUPLICATE_NUMBERS("[ERROR] 로또 번호에 중복된 숫자가 있습니다."),
    OUT_OF_RANGE_NUMBER("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_NUMBER_FORMAT("[ERROR] 입력된 숫자 형식이 올바르지 않습니다."),
    INCORRECT_NUMBER_COUNT("[ERROR] 로또 번호는 6개여야 합니다.");

    private final String message;
    LottoExceptionMessages(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }

    public void printError() {
        System.out.println(getMessage());
    }
}
