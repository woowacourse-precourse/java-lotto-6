package lotto;

public enum ErrorMessage {
    NOT_NUMBER("숫자가 아닙니다."),
    PAYMENT_AMOUNT_INVALID("구입 금액이 %d원으로 나누어 떨어지지 않습니다.".formatted(LottoConfig.PRICE.getLottoConfig())),
    LOTTO_NUMBER_OUT_OF_RANGE("로또 번호가 %d~%d 사이의 숫자가 아닙니다.".formatted(LottoConfig.LOTTO_NUMBER_MIN.getLottoConfig(), LottoConfig.LOTTO_NUMBER_MAX.getLottoConfig())),
    LOTTO_LENGTH_INVALID("로또 번호가 %d개가 아닙니다.".formatted(LottoConfig.LOTTO_LENGTH.getLottoConfig())),
    LOTTO_NUMBERS_DUPLICATE("로또 번호가 중복됩니다."),
    BONUS_NUMBER_DUPLICATE("보너스 번호가 당첨 번호와 중복됩니다.");

    public static final String HEADER = "[ERROR] ";
    private final String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = HEADER + errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
