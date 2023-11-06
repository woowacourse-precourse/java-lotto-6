package lotto.exception;

public enum Errors {
    INVALID_SIZE("[ERRORS] 올바른 로또번호의 갯수가 아닙니다."),
    INVALID_MONEY("[ERRORS] 돈이 모자랍니다."),
    GREATER_THAN_MAXIMUM_PURCHASE_LIMIT("[ERRORS] 최대 구매 한도를 초과했습니다."),
    INVALID_BONUS_NUMBER("[ERRORS] 보너스번호는 당첨번호와 중복될 수 없습니다."),
    NOT_DIVISIBLE_BY_PRICE("[ERRORS] 올바른 단위의 수가 아닙니다."),
    IS_NOT_NUMBER("[ERRORS] 숫자를 입력하세요.");

    private final String message;

    Errors(String message) {
        this.message = message;
    }

    public LottoException getLottoException() {
        return new LottoException(this.message);
    }

    public FormatException getFormatException() {
        return new FormatException(this.message);
    }

}
