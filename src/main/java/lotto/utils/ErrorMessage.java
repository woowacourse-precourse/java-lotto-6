package lotto.utils;

public enum ErrorMessage {
    ERROR_MESSAGE("[ERROR] "),
    BUY_PRICE_PATTERN_ERROR("로또 구입 금액은 숫자를 입력해야 합니다."),
    BUY_PRICE_UNIT_ERROR("로또 구입 금액은 1000원 단위로 입력해야 합니다."),
    BONUS_NUMBER_PATTERN_ERROR("보너스 번호는 숫자를 입력해야 합니다."),
    BONUS_NUMBER_RANGE_ERROR("보너스 번호는 1부터 45사이의 숫자를 입력해야 합니다."),
    WINNING_NUMBER_DUPLICATE_ERROR("각각 다른 숫자를 입력해야 합니다."),
    WINNING_NUMBER_STRING_ERROR("당첨 번호는 '1,2'와 같이 숫자쉼표숫자의 형태로 입력해야하고 총 6개의 숫자를 입력해야 합니다."),
    WINNING_NUMBER_RANGE_ERROR("당첨 번호는 1부터 45사이의 숫자를 입력해야 합니다."),
    WINNING_NUMBER_ERROR("당첨 번호는 숫자를 입력해야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
