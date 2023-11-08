package lotto.constants;

public enum ErrorMessage implements LottoConstants {
    PURCHASE_AMOUNT(LOTTO_PRICE + "원 단위의 숫자만 입력해 주세요."),
    ZERO_NUMBER("0보다 큰 숫자를 입력해 주세요."),
    NOT_NUMBER("숫자를 제대로 입력했는지 확인해 주세요."),
    LOTTO_SIZE(LottoConstants.LOTTO_SIZE + "개의 숫자를 입력해 주세요."),
    DUPLICATE("중복된 숫자 없이 입력해 주세요."),
    NUMBER_RANGE(MIN_NUMBER + "에서 " + MAX_NUMBER + " 사이의 숫자를 입력해 주세요."),
    DUPLICATE_OF_WINNING_NUMBERS("당첨 번호와 중복되지 않는 숫자를 입력해주세요.");

    private static final String ERROR_FORMAT = "[ERROR] %s";
    private String errorMessage;

    ErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @Override
    public String toString() {
        return String.format(ERROR_FORMAT, errorMessage);
    }
}
