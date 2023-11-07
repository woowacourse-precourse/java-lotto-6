package lotto.constants;

public enum UserAmountErrorMessage implements ErrorMessage{

    EMPTY_INVALID("로또 구입 금액은 공백이 포함될 수 없습니다."),
    NOT_DIVIDE_STANDARD_INVALID("로또 구입 금액은 1000으로 나누어떨어져야 합니다."),
    NOT_ZERO_INVALID("구입 금액이 0원이 아닌 값을 입력해야 합니다."),
    NATURE_NUMBER_INVALID("구입 금액이 음수가 아닌 값을 입력해야 합니다.");

    private final String message;

    UserAmountErrorMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
