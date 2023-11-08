package lotto.enums;

public enum LottoErrorCodes {

    INVALID_INTEGER_INPUT("[ERROR] 정수형 숫자만 입력할 수 있습니다."),
    MINIMUM_AMOUNT_ERROR("[ERROR] 구매 금액은 최소 1000원 입니다."),
    AMOUNT_UNIT_ERROR("[ERROR] 구매 금액은 1000원 단위로 입력해야 합니다."),
    BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다."),
    ONLY_NUMBER_ALLOWED("[ERROR] 숫자만 입력할 수 있습니다."),
    NUMBER_RANGE_ERROR("[ERROR] 숫자는 %d에서 %d 사이어야 합니다."), // Placeholder for actual numbers
    EXACT_NUMBER_REQUIRED("[ERROR] 정확히 6개의 숫자를 입력해야 합니다.");

    private final String message;

    LottoErrorCodes(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithNumbers(int minimumNumber, int maximumNumber) {
        if (this == NUMBER_RANGE_ERROR) {
            return String.format(message, minimumNumber, maximumNumber);
        } else {
            return getMessage();
        }
    }
}
