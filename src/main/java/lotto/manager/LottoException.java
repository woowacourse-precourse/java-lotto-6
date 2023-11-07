package lotto.manager;

public enum LottoException {
    PURCHASE_AMOUNT_OUT_OF_RANGE("[ERROR] 구입금액은 1000원 미만일 수 없습니다."),
    PURCHASE_AMOUNT_WRONG_UNIT("[ERROR] 구입금액은 1000원 단위로 입력해주세요."),
    PURCHASE_AMOUNT_NOT_NUMBER("[ERROR] 구입금액은 숫자로 입력해주세요."),
    NOT_NUMBER("[ERROR] 숫자로 입력해주세요."),
    LOTTO_NUMBERS_COUNT_OUT_OF_RANGE("[ERROR] 로또 번호는 6개로 구성됩니다."),
    LOTTO_NUMBER_OUT_OF_RANGE("[ERROR] 로또 번호는 1~45 사이의 숫자입니다."),
    LOTTO_NUMBER_HAS_DUPLICATES("[ERROR] 로또 번호는 중복될 수 없습니다."),
    EMPTY_OR_BLANK_INPUT("[ERROR] 정상적인 입력이 아닙니다."),
    BONUS_NUMBER_IN_WINNING_NUMBERS("[ERROR] 보너스 번호는 당첨 번호에 없는 숫자로 골라야 합니다.");

    private final String errorMessage;

    LottoException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public void throwing() {
        System.out.println(errorMessage);
        throw new IllegalArgumentException(errorMessage);
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
