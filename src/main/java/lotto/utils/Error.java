package lotto.utils;

public enum Error {
    INVALID_PURCHASE_AMOUNT("[ERROR] 구입 금액은 1000원 단위여야 합니다."),
    DUPLICATED_WINNING_NUMBER("[ERROR] 당첨 번호는 중복될 수 없습니다."),
    INVALID_WINNING_NUMBER("[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_BONUS_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
