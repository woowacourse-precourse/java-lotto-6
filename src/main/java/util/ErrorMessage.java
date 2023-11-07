package util;

public enum ErrorMessage {
    PURCHASE_AMOUNT_CAN_ONLY_NUMBER("[ERROR] 구입 금액은 숫자로만 구성됩니다."),
    PURCHASE_AMOUNT_MUST_BE_OVER_1000("[ERROR] 구입 금액은 1,000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_ACCEPT_ONLY_UNIT_OF_1000("[ERROR] 구입 금액은 1,000원 단위로 입력 받습니다."),
    PRIZE_NUMBER_CAN_ONLY_NUMBER_AND_COMMA("[ERROR] 당첨 번호는 숫자로 구성되고 쉼표(,)로 공백 없이 구분됩니다."),
    PRIZE_NUMBER_MUST_BE_UNDER_45("[ERROR] 당첨 번호는 45 이하의 숫자로 구성됩니다."),
    PRIZE_NUMBER_MUST_NOT_BE_DUPLICATED("[ERROR] 당첨 번호는 중복되면 안됩니다."),
    PRIZE_NUMBER_MUST_BE_SIX_DIGITS("[ERROR] 당첨 번호는 6개의 숫자로 구성됩니다."),
    BONUS_NUMBER_CAN_ONLY_NUMBER("[ERROR] 보너스 번호는 숫자로만 구성됩니다."),
    BONUS_NUMBER_MUST_BE_UNDER_45("[ERROR] 보너스 번호는 45 이하의 숫자로 구성됩니다."),
    BONUS_NUMBER_MUST_NOT_BE_DUPLICATED_WITH_PRIZE_NUMBER("[ERROR] 보너스 번호는 당첨 번호와 중복되면 안됩니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
