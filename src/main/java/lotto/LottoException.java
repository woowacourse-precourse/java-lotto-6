package lotto;

public enum LottoException {
    INPUT_NOT_DiGIT("[ERROR] 숫자로 입력해 주세요."),
    INPUT_NOT_THOUSAND_UNITS("[ERROR] 구입금액을 1,000원 단위로 입력하세요."),
    INPUT_NOT_SPLIT("[ERROR] 쉼표(,)를 기준으로 6자리를 입력해주세요."),
    INPUT_NOT_RANGE("[ERROR] 1~45 사이의 숫자를 입력해 주세요."),
    INPUT_DUPLICATION_NUMBER("[ERROR] 숫자가 중복됩니다."),
    LOTTO_NUMBER_DUPLICATION("[ERROR] 로또 번호에 중복이 있습니다."),
    LOTTO_NUMBER_NOT_SIX_DIGITS("[ERROR] 로또 번호가 6자리가 아닙니다.")
    ;


    final private String message;

    LottoException(String message) {
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
