package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("[ERROR] 숫자만을 입력하세요"),
    BLANK_INPUT("[ERROR] 빈칸을 입력하지마세요."),
    NOT_THOUSAND("[ERROR] 천원단위로 입력하세요"),
    NOT_LOTTO_COUNTS("[ERROR] 로또 번호는 6개를 입력하세요"),
    DUPLICATION_NUMBER("[ERROR] 중복된 번호를 입력하지마세요"),
    PURCHASE_AMOUNT_ZERO("[ERROR] 0원을 입력하지마세요"),
    NOT_NUMBER_ARRANGE("[ERROR] 1부터 45의 숫자만 입력하세요"),
    DUPLICATE_WIN_BONUS_NUM("[ERROR] 당첨 번호와 보너스 번호가 중복되지마세요");

    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
