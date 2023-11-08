package lotto.Exception;

public enum LottoNumberErrorMessage {
    IS_NOT_ASCENDING_NUMBER("[ERROR] 로또 넘버는 오름차순 정렬되어야 합니다.");

    private final String message;

    LottoNumberErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
