package lotto;

public enum ErrorCode {
    LOTTERY_NUMBER_DUPLICATED_ERROR("로또 번호는 중복될 수 없습니다."),
    LOTTERY_NUMBER_RANGE_ERROR("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    LOTTERY_SIZE_ERROR("당첨 번호는 6개의 숫자여야 합니다."),
    PURCHASE_AMOUNT_ERROR("구매 금액은 1000원 단위로 입력해 주세요.");
    private final String message;

    ErrorCode(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
