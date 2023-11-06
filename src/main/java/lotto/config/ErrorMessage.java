package lotto.config;

public enum ErrorMessage {

    PURCHASE_ONLY_NUMBER_ERROR("[ERROR] 구매 금액은 숫자만 입력가능합니다."),
    NOT_THOUSAND_DIVIDED_ERROR("[ERROR] 금액은 1,000원 단위로만 입력이 가능합니다."),
    LOTTO_NEED_SIX_NUMBER_ERROR("[ERROR] 로또 번호는 총 6개가 있어야 합니다."),
    LOTTO_DISTINCT_ERROR("[ERROR] 로또에 중복된 번호는 불가능합니다."),
    LOTTO_EXCEED_RANGE_ERROR("[ERROR] 로또의 번호는 1 ~ 45까지만 가능합니다."),
    WINNING_NUMBER_ONLY_NUMBER_ERROR("[ERROR] 당첨 번호는 숫자만 입력가능합니다. (공백 불가)"),
    BONUS_ONLY_NUMBER_ERROR("[ERROR] 보너스 번호는 숫자만 입력가능합니다."),
    BONUS_EXCEED_RANGE_ERROR("[ERROR] 보너스 번호는 1 ~ 45까지만 가능합니다."),
    BONUS_DISTINCT_WINNING_NUMBER_ERROR("[ERROR] 당첨 번호와 중복된 숫자입니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
