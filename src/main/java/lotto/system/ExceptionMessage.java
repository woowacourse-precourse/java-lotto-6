package lotto.system;

public enum ExceptionMessage {
    LOTTO_LENGTH(String.format("로또 번호는 %d 가지 숫자여야 합니다.", LottoNumberConstant.LENGTH.getValue())),
    LOTTO_DISTINCT("중복되는 로또 번호가 있으면 안 됩니다.");

    private final String message;

    ExceptionMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return "[ERROR] " + message;
    }
}
