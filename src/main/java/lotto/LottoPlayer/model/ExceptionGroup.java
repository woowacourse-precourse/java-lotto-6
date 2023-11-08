package lotto.LottoPlayer.model;

public enum ExceptionGroup {
    THOUSAND_UNIT_ERROR("[ERROR]1000원 단위로만 구매 가능합니다."),
    OUT_OF_RANGE_ERROR("[ERROR]1~45 사이의 숫자만 입력 가능합니다."),
    NOT_VALID_ERROR("[ERROR]숫자와 쉼표만 입력 가능합니다."),
    NOT_NUMBER_ERROR("[ERROR]숫자만 입력 가능합니다."),
    DUPLICATION_ERROR("[ERROR]중복된 숫자가 있습니다."),
    ;

    private final String error_message;

    ExceptionGroup(String error_message) {
        this.error_message = error_message;
    }

    public String getMessage() {
        return error_message;
    }
}
