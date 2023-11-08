package lotto.domain.exception;

public enum LottoExceptionList {
    NUMBERS_DUPLICATE_ERROR("[ERROR] 중복된 숫자가 있습니다. 다시 입력해주세요."),
    NUMBER_IS_EMPTY("[ERROR] 입력된 숫자가 없습니다."),
    NUMBERS_NOT_PURE_ERROR("[ERROR] 숫자만 입력해주세요."),
    NUMBERS_NOT_DIVIDED_ERROR("[ERROR] 구입 금액은 1,000원 단위로 입력하세요."),
    NUMBERS_INVALID_ERROR("[ERROR] 1이상 45이하의 숫자를 입력해주세요."),
    NUMBERS_LENGTH_ERROR("[ERROR] 6자리 숫자를 입력해주세요."),
    NUMBERS_NOT_POSITIVE_ERROR("[ERROR] 양의 정수만 입력해주세요."),
    NUMBER_ALREADY_EXISTS_IN_LIST_ERROR("[ERROR] 당첨번호 리스트에 동일한 숫자가 있습니다.");

    private final String message;

    LottoExceptionList(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
