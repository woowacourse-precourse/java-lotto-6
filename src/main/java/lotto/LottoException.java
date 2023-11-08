package lotto;

public enum LottoException {
    LOTTO_NUMBER_INVALID_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTO_NUMBER_NOT_ORDERED("숫자가 정렬되어 있지 않습니다."),
    LOTTO_HAS_DUPLICATE_NUM("중복된 번호가 존재합니다."),
    LOTTO_BOUNS_NUM_IS_DUPLECATE("보너스 번호는 당첨번호와 같을 수 없습니다."),
    LOTTO_NUMBER_INVALID_SIZE("로또의 당첨 번호는 6개이어야 합니다.");

    LottoException(String message) {
        this.message = message;
    }
    private final String message;

    public String getMessage() {
        return message;
    }
}
