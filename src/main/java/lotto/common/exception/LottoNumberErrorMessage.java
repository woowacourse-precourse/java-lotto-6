package lotto.common.exception;

public enum LottoNumberErrorMessage {

    OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    NOT_DUPLICATION("로또 번호는 중복되서는 안됩니다.");

    private final String errorMessage;

    LottoNumberErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

}
