package lotto.domain.ticket;

public enum LottoErrorMessage {
    SIZE_ERROR("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    DUPLICATION_ERROR("[ERROR] 로또 번호는 중복이 없어야 합니다."),
    INVALID_RANGE_ERROR("[ERROR] 로또 번호는 1~45 사이여야 합니다.");

    private final String message;

    LottoErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
