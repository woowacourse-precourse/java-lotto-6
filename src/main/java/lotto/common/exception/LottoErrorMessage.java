package lotto.common.exception;

public enum LottoErrorMessage {
    INVALID_LOTTO_SIZE("로또는 정해진 숫자 크기만큼 숫자가 있어야 합니다."),
    DUPLICATE_LOTTO_NUMBERS("로또 번호는 중복되서는 안됩니다.");

    private final String errorMessage;

    LottoErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
