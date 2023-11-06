package lotto.util;

public enum ErrorMessages {
    MONEY_CANT_DIVIDE_ERROR("[ERROR] 1,000원 단위로 입력해주세요."),
    ISSUE_COUNT_ERROR("[ERROR] 발행 횟수는 음수일 수 없습니다."),
    DUPLICATE_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호와 로또 번호는 중복일 수 없습니다."),
    NOT_SIX_NUMBER_ERROR("[ERROR] 로또 번호는 6자리 입니다."),
    MONEY_NOT_NEGATIVE("[ERROR] 금액은 음수일 수 없습니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 로또 번호는 중복된 숫자를 가질 수 없습니다."),
    NOT_MONEY_FORMAT_ERROR("[ERROR] 구입금액을 다시 입력해주세요."),
    OVER_OR_UNDER_NUMBER_RANGE_ERROR("[ERROR] 로또 번호는 1 ~ 45 사이 입니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
