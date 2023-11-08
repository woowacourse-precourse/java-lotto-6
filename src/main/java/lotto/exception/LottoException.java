package lotto.exception;

public enum LottoException {

    LOTTO_NUMBER_COUNT_NOT_CORRECT("로또 번호는 6개를 입력하셔야 합니다."),
    LOTTO_NUMBER_MUST_UNIQUE("로또 번호는 중복될 수 없습니다."),
    BELOW_RANGE_LOTTO_NUMBER("로또 번호는 1이상부터 입력하실 수 있습니다."),
    OVER_RANGE_LOTTO_NUMBER("로또 번호는 46까지 입력하실 수 있습니다."),
    BONUS_NUMBER_CAN_NOT_CONTAIN_WINNING_LOTTO("보너스 번호와 당첨 번호는 중복될 수 없습니다."),
    CAN_NOT_PURCHASE_ONE_LOTTO("로또 최소 구매 금액은 1,000원 입니다."),
    CAN_NOT_GIVE_CHANGE("로또는 1,000원 단위로 구매 하셔야 합니다."),
    INPUT_ONLY_NUMBER("숫자만 입력하실 수 있습니다.");

    private final String message;
    private static final String ERROR_INFORMATION_MESSAGE = "[ERROR] ";

    LottoException(String message) {
        this.message = message;
    }

    public void create() {
        throw new IllegalArgumentException(ERROR_INFORMATION_MESSAGE + this.message);
    }
}
