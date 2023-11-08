package lotto.validation;

public enum ErrorMessage {
    ERROR_BONUS_IS_NUMBER("[ERROR] 보너스 번호는 숫자만 입력 가능합니다."),
    ERROR_BONUS_IN_RANGE_NOT_DUPLICATION("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없고, 1부터 45 사이의 숫자만 가능합니다."),
    ERROR_PURCHASE_MIN_MAX("[ERROR] 구매 가격은 최소 1,000원부터 최대 100,000원까지 입력 가능합니다."),
    ERROR_PURCHASE_DIVIDED_ONE_THOUSAND("[ERROR] 구매 가격은 1000원으로 나누어 떨어져야 합니다."),
    ERROR_WINNING_CONTAINS_COMMA("[ERROR] 로또 번호는 공백 없이 6개의 숫자 사이에 콤마를 넣어야 합니다."),
    ERROR_WINNING_IN_RANGE_NOT_DUPLICATION("[ERROR] 로또 번호는 중복될 수 없고, 1부터 45 사이의 숫자여야 합니다.");
    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
