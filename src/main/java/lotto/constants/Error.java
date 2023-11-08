package lotto.constants;

public enum Error {

    NOT_NUMBER_ERROR("[ERROR] 양의 정수만 입력해주세요"),
    INVALID_AMOUNT_ERROR("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    ZERO_ERROR("[ERROR] 구입 금액은 0보다 큰 수여야 합니다"),
    RANGE_ERROR("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    SIZE_ERROR("[ERROR] 로또 번호는 6개의 숫자여야 합니다"),
    DUPLICATION_ERROR("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다"),
    DUPLICATION_BONUS_ERROR("[ERROR] 당첨 번호와 보너스 번호는 중복될 수 없습니다."),
    FORMAT_ERROR("[ERROR] 포맷에 맞게 입력 해주세요. ex) 1,2,3,4,5,6");

    private final String message;

    Error(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
