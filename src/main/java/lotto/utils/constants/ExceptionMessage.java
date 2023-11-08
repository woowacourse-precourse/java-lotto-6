package lotto.utils.constants;

public enum ExceptionMessage {
    INPUT_STRING_NOT_NUMBER("문자열이 아닌 숫자로 된 값을 입력해주세요."),
    INPUT_BLANK("아무 값도 입력하지 않았습니다. 숫자로 된 값을 입력해주세요."),
    INPUT_SHOULD_BE_IN_RANGE("1에서 45 사이의 숫자를 입력해야 합니다."),
    PURCHASE_AMOUNT_SHOULD_BE_MULTIPLE_OF_THOUSAND("1,000원 단위의 구매 금액을 입력해주세요."),
    LOTTO_NUMBER_LIST_SIZE("6개의 숫자를 콤마로 구분하여 입력해주세요."),
    LOTTO_NUMBER_HAS_DUPLICATED_NUMBER("중복된 숫자를 입력했습니다."),
    INPUT_LOTTO_NUM_DUPLICATED_BONUSNUM("입력하신 당첨 번호와 중복되지 않은 보너스 숫자를 입력해주세요.");

    private final String message;

    ExceptionMessage(final String message) {
        this.message = "[ERROR] " + message;
    }

    public String getMessage() {
        return message;
    }
}
