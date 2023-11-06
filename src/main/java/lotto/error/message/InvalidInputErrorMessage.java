package lotto.error.message;

public enum InvalidInputErrorMessage implements ErrorMessage {
    NOT_A_NUMBER("입력하신 값은 숫자가 아닙니다."),
    PURCHASE_AMOUNT_UNDER_THOUSAND("구입 금액은 1000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND("구입 금액은 1000원 단위만 가능합니다."),
    OUT_OF_RANGE("입력범위를 초과했습니다."),
    WINNING_NUMBERS_DUPLICATE("입력하신 당첨 번호에 중복이 존재합니다."),
    BONUS_NUMBER_IN_WINNING_NUMBER("입력하신 보너스 번호가 이미 당첨 번호에 존재합니다.");

    private final String message;

    InvalidInputErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
