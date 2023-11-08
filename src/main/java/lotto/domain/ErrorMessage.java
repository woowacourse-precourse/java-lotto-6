package lotto.domain;

public enum ErrorMessage {
    PURCHASE_AMOUNT_CONVERT_EXCEPTION("[ERROR] 구매 금액은 숫자만 입력 가능합니다.\n"),
    PURCHASE_AMOUNT_THOUSAND_EXCEPTION("[ERROR] 구매 금액은 1,000단위로 입력해야 합니다.\n"),
    PURCHASE_AMOUNT_MAXVALUE_EXCEPTION("[ERROR] 구매 금액은 MAX_VALUE원을 넘을 수 없습니다.\n"),
    WINNING_NUMBER_SIX_EXCEPTION("[ERROR] 당첨 번호는 ',' 기준으로 6자리를 입력해야 합니다.\n"),
    WINNING_NUMBER_CONVERT_EXCEPTION("[ERROR] 당첨 번호는 숫자만 입력 가능합니다.\n"),
    WINNING_NUMBER_RANGE_EXCEPTION("[ERROR] 당첨 번호는 1~45까지 가능합니다.\n"),
    WINNING_NUMBER_DUPLICATE_EXCEPTION("[ERROR] 당첨 번호는 중복될 수 없습니다.\n"),
    BONUS_NUMBER_CONVERT_EXCEPTION("[ERROR] 보너스 번호는 숫자만 입력 가능합니다.\n"),
    BONUS_NUMBER_RANGE_EXCEPTION("[ERROR] 보너스 번호는 1~45까지 가능합니다.\n"),
    BONUS_NUMBER_DUPLICATE_EXCEPTION("[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.\n"),
    LOTTO_NUMBER_SIX_EXCEPTION("[ERROR] 로또 숫자는 6자리를 입력해야 됩니다."),
    LOTTO_NUMBER_DUPLICATE_EXCEPTION("[ERROR] 중복된 숫자가 입력되었습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMaxValueMessage(String maxValue) {
        return this.message.replace("MAX_VALUE", maxValue);
    }
}
