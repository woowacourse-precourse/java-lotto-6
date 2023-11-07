package lotto.exception;

public enum WinningLottoException implements CustomException {

    DUPLICATE_BONUS_NUMBER("로또 번호와 보너스 번호가 중복되면 안됩니다.");

    private final String message;

    WinningLottoException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
