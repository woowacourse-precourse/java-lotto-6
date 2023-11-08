package lotto.enums;

public enum LottoErrorCodes {

    INVALID_INTEGER_INPUT("[ERROR] 정수형 숫자만 입력할 수 있습니다."),
    MINIMUM_AMOUNT_ERROR("[ERROR] 구매 금액은 최소 " + LottoConstants.LOTTO_TICKET_PRICE.getValue() + "원 입니다."),
    AMOUNT_UNIT_ERROR("[ERROR] 구매 금액은 " + LottoConstants.LOTTO_TICKET_PRICE.getValue() + "원 단위로 입력해야 합니다."),
    DIFFERENT_BONUS_NUMBER_ERROR("[ERROR] 보너스 번호는 당첨 번호와 다른 번호여야 합니다."),
    NUMBERS_ONLY_INPUT("[ERROR] 숫자만 입력할 수 있습니다."),
    NUMBER_RANGE_ERROR("[ERROR] 숫자는 %d에서 %d 사이어야 합니다.", LottoConstants.MINIMUM_NUMBER.getValue(), LottoConstants.MAXIMUM_NUMBER.getValue()),
    EXACT_NUMBER_REQUIRED("[ERROR] 정확히 " + LottoConstants.NUMBERS_PER_TICKET.getValue() + "개의 숫자를 입력해야 합니다."),
    DUPLICATE_NUMBER_ERROR("[ERROR] 중복된 숫자가 있습니다."),
    INTEGER_RANGE_EXCEEDED("[ERROR] -2,147,483,648에서 2,147,483,647 사이로 입력해주세요.");

    private final String message;
    private final int minimumNumber;
    private final int maximumNumber;

    LottoErrorCodes(String message) {
        this.message = message;
        this.minimumNumber = -1;
        this.maximumNumber = -1;
    }

    LottoErrorCodes(String message, int minimumNumber, int maximumNumber) {
        this.message = message;
        this.minimumNumber = minimumNumber;
        this.maximumNumber = maximumNumber;
    }

    public String getMessage() {
        if (this == NUMBER_RANGE_ERROR) {
            return String.format(message, minimumNumber, maximumNumber);
        } else {
            return message;
        }
    }
}
