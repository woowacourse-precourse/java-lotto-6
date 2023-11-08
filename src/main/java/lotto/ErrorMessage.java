package lotto;

public enum ErrorMessage {
    INPUT_NOT_NUMBER("[ERROR] 숫자로 변환할 수 없는 입력입니다. 다시 입력해주세요."),
    NOT_DIVISIBLE_LOTTO_PRICE(String.format("[ERROR] %d으로 나누어 떨어지는 금액을 입력해야 합니다. 다시 입력해주세요.", LottoManagement.PRICE_LOTTO)),
    INVALID_LOTTO_NUMBERS(String.format("[ERROR] 입력한 로또 번호가 유효하지 않습니다. ,를 포함하여 %d ~ %d 범위의 중복되지 않는 %d 자리를 입력해주세요.",
            LottoConst.MIN_RANGE_NUMBER.getValue(), LottoConst.MAX_RANGE_NUMBER.getValue(), LottoConst.LOTTO_NUMBER_COUNT.getValue()));


    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
