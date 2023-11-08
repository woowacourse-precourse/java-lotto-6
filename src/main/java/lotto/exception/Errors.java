package lotto.exception;

public enum Errors {
    INVALID_NOT_NUMBER("[ERROR] 숫자를 입력하지 않았거나 유효한 숫자가 아닙니다."),
    INVALID_MONEY("[ERROR] 돈이 모자랍니다."),
    INVALID_LIMIT("[ERROR] 최대 구매 한도를 초과했습니다."),
    INVALID_INDIVISIBLE("[ERROR] 올바른 단위의 수가 아닙니다."),
    INVALID_QUANTITY("[ERROR] 유효하지 않은 구매 수입니다."),
    INVALID_SIZE("[ERROR] 올바른 로또번호의 갯수가 아닙니다."),
    INVALID_DUPLICATED("[ERROR] 당첨번호는 중복될수 없습니다."),
    INVALID_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_SORTING("[ERROR] 정렬되지 않은 로또번호가 생성되었습니다."),
    INVALID_BONUS_NUMBER("[ERROR] 보너스번호는 당첨번호와 중복될 수 없습니다.");


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

    public StatusException getStatusException() {
        return new StatusException(this.message);
    }

}
