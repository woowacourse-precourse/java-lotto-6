package lotto.Message.ExceptionMessage;

public enum LottoExceptionMessage {
    LOTTO_SIZE_ERROR_MESSAGE("로또 번호의 수가 6개가 아닙니다."),
    LOTTO_DUPLICATE_ERROR_MESSAGE("로또 번호가 중복되었습니다."),
    LOTTO_DUPLICATE_WITH_BONUS_NUMBER_ERROR_MESSAGE("로또 번호와 보너스 번호가 중복되었습니다.");

    private String message;

    LottoExceptionMessage(String message) {
        this.message = PrefixMessage.ERROR_MESSAGE.getMessage() + message;
    }

    public String getMessage() {
        return this.message;
    }
}
