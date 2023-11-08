package lotto.constant;

public enum Message {
    ERROR_LOTTO_NUMBERS_OUT_OF_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    ERROR_LOTTO_NUMBERS_NOT_SIX("[ERROR] 로또 번호는 6개의 숫자여야 합니다."),
    ERROR_LOTTO_NUMBERS_DUPLICATED("[ERROR] 로또 번호는 중복되지 않는 숫자여야 합니다."),
    ERROR_BONUS_NUMBER_DUPLICATED("[ERROR] 당첨 번호에 보너스 번호가 포함될 수 없습니다."),
    ERROR_PURCHASE_AMOUNT_INVALID_UNIT("[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다."),
    ERROR_PURCHASE_AMOUNT_UNDER_MINIMUM("[ERROR] 구입 금액은 1,000원 미만일 수 없습니다."),
    ERROR_PURCHASE_AMOUNT_OVER_MAXIMUM("[ERROR] 구입 금액은 100,000원을 초과할 수 없습니다."),
    ERROR_INPUT_SPACED("[ERROR] 공백이 없이 입력해야 합니다."),
    ERROR_INPUT_NOT_ONLY_NUMBER("[ERROR] 숫자만 입력해야 합니다."),
    ERROR_INPUT_ZERO_LEADING_NUMBER("[ERROR] 숫자는 0으로 시작하지 않는 숫자여야 합니다."),
    ERROR_INPUT_NON_PARSABLE_NUMBER("[ERROR] 숫자는 9자리이하만 입력해야 합니다."),
    ERROR_INPUT_INVALID_LOTTO_NUMBERS(
            "[ERROR] 당첨 번호는 1에서 45 사이의 숫자를 쉼표(,)로 구분해서 6개 입력해야 합니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    @Override
    public String toString() {
        return this.name() + " = " + message;
    }
}
