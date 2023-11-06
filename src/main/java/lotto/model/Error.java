package lotto.model;

public enum Error {

    NOT_DIVIDED_BY_LOTTO_PRICE("[ERROR] 로또 구입 가격은 로또 하나의 가격인 1000원으로 나누어 떨어져야 합니다."),
    NOT_NUMERIC_PURCHASE_PRICE("[ERROR] 구입 금액은 숫자이어야 합니다."),
    NOT_NUMERIC_WINNING_NUMBER("[ERROR] 당첨 번호는 숫자이어야 합니다."),
    NOT_UNIQUE_WINNING_NUMBER("[ERROR] 당첨 번호는 중복되지 않아야 합니다."),
    NOT_VALID_WINNING_NUMBER_COUNT("[ERROR] 당첨 번호는 총 6개입니다."),
    NOT_VALID_WINNING_NUMBER_RANGE("[ERROR] 당첨 번호는 1에서 45 사이의 숫자입니다."),
    NOT_NUMERIC_BONUS_NUMBER("[ERROR] 보너스 번호는 숫자이어야 합니다."),
    NOT_VALID_BONUS_NUMBER_RANGE("[ERROR] 보너스 번호는 1에서 45 사이의 숫자입니다.");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public void throwError() {
        throw new IllegalArgumentException(message);
    }
}
