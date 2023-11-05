package lotto.domain;

public enum Error {
    RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    DUPLICATED_ERROR("로또 번호는 서로 다른 6자리이여야 합니다."),
    CASH_ERROR("구입 금액을 1,000원 단위로 입력해주세요."),
    LOTTO_NUMBER_COUNT_ERROR("로또 번호는 6자리로 입력해주세요.");

    private String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
