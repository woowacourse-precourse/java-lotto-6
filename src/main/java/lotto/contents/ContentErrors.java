package lotto.contents;

public enum ContentErrors {
    NEGATIVE_AMOUNT("[ERROR] 구입 금액은 음수일 수 없습니다."),
    INVALID_AMOUNT("[ERROR] 입력한 금액이 유효하지 않습니다. 1,000원 단위로 입력해주세요."),
    INVALID_NUMBER_FORMAT("[ERROR] 숫자 형식이 올바르지 않습니다."),
    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATE_NUMBER("[ERROR] 로또 번호는 중복될 수 없습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호가 올바르지 않습니다."),
    INVALID_WINNING_NUMBERS("[ERROR] 당첨 번호가 올바르지 않습니다.");

    private final String errorMessage;

    ContentErrors(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}


