package lotto.util;

public enum ExceptionMessage {
    NOT_POSITIVE_NUMBER_MESSAGE("양수의 숫자를 입력해야합니다."),
    NULL_INPUT_MESSAGE("입력값이 비어있습니다."),
    NOT_NUMBER_MESSAGE("당첨 번호는 숫자만 가능합니다."),
    OVER_LOTTO_NUMBER_RANGE_MESSAGE(
            "로또 번호는 " + LottoConstants.MIN_NUMBER_RANGE.getValue() + "부터 " + LottoConstants.MAX_NUMBER_RANGE
                    + "사이의 숫자여야 합니다."),
    NOT_LOTTO_NUMBER_COUNT_MESSAGE("로또 번호는 " + LottoConstants.NUMBER_COUNT.getValue() + "개여야 합니다."),
    DUPLICATION_NUMBER_MESSAGE("로또 번호는 서로 중복일 수 없습니다."),
    DUPLICATION_BONUS_NUMBER_MESSAGE("로또 번호와 보너스 번호는 중복될 수 없습니다."),
    NOT_ALLOW_PURCHASE_AMOUNT_UNIT_MESSAGE("구입 금액은 " + LottoConstants.LOTTO_PRICE.getValue() + "원 단위로 입력해야 합니다."),
    NOT_ALLOW_FORMAT_INPUT_MESSAGE("옳지 않은 형식의 당첨 번호 입력입니다. 올바른 형식으로 다시 입력해주세요.");

    private static final String ERROR_MESSAGE = "[ERROR]";
    private static final String SPACE = " ";

    private String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getErrorMessage() {
        return ERROR_MESSAGE + SPACE + message;
    }
}
