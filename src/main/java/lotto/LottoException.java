package lotto;

public enum LottoException {
    INPUT_NOT_DiGIT("[ERROR] 숫자로 입력해 주세요."),
    INPUT_NOT_THOUSAND_UNITS("[ERROR] 구입금액을 1,000원 단위로 입력하세요."),
    INPUT_NOT_SPLIT("[ERROR] 쉼표(,)를 기준으로 6자리를 입력해주세요."),
    INPUT_NOT_RANGE("[ERROR] 1~45 사이의 숫자를 입력해 주세요.")
    ;


    final private String message;

    LottoException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
