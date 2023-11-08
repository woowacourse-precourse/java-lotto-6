package lotto.ui;

public enum ErrorMessage {
    COMMON_MESSAGE("다시 입력해 주세요."),
    EMPTY_ERROR("[ERROR] 입력값이 없습니다."),
    NUMERIC_ERROR("[ERROR] 숫자만 입력할 수 있습니다."),
    AMOUNT_LIMIT_ERROR("[ERROR] 최대한도는 100,000원입니다."),
    AMOUNT_UNIT_ERROR("[ERROR] 1,000원 단위로 입력해 주세요."),
    NUMBER_DUPLICATE_ERROR("[ERROR] 당첨 번호와 보너스 번호인 7개의 숫자는 중복해서 사용할 수 없습니다."),
    NUMBER_FORMAT_ERROR("[ERROR] 당첨 번호는 6개의 숫자를 쉼표(,)로 구분해서 입력해 주세요. ex) 1,2,3,4,5,6\n"),
    NUMBER_RANGE_ERROR("[ERROR] 번호는 1부터 45 사이의 숫자여야 합니다."),
    NUMBER_SIZE_ERROR("[ERROR] 당첨 번호는 6개의 숫자로 이루어져야 합니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}