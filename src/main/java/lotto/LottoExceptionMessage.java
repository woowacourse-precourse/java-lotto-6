package lotto;

public enum LottoExceptionMessage {

    NOT_SATISFY_REQUIRED_COUNT("[ERROR] 로또 번호는 6개여야 합니다."),
    DUPLICATE_EXISTS("[ERROR] 로또 번호가 중복 입니다."),
    INVALID_NUMBER("[ERROR] 로또 번호가 유효하지 않습니다.");

    private final String error;

    LottoExceptionMessage(String error) {
        this.error = error;
    }

    public String getError() {
        return error;
    }
}
