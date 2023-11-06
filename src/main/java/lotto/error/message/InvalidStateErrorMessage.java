package lotto.error.message;

public enum InvalidStateErrorMessage implements ErrorMessage {
    LOTTO_NUMBERS_COUNT_NOT_SIX("로또 번호는 6개여야 합니다."),
    LOTTO_NUMBERS_DUPLICATE("6개의 로또 번호는 중복될 수 없습니다."),
    LOTTO_NUMBERS_OUT_OF_RANGE("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    PURCHASE_AMOUNT_UNDER_THOUSAND("구입 금액은 1000원 이상이어야 합니다."),
    PURCHASE_AMOUNT_NOT_MULTIPLE_OF_THOUSAND("구입 금액은 1000의 배수만 가능합니다.");

    private final String message;

    InvalidStateErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
