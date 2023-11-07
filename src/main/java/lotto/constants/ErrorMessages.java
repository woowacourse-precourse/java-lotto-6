package lotto.constants;

public enum ErrorMessages {
    INPUT_MONEY_RANGE("구입 금액은 1000원 이상 이어야 합니다."),
    INPUT_MONEY_UNIT("구입 금액은 1000원 단위로 입력 해야 합니다."),
    INPUT_MONEY_NUMERIC("구입 금액은 숫자로 입력 해야 합니다."),
    INPUT_LOTTO_SIZE("로또는 6개의 숫자로 이루어 져야 합니다."),
    INPUT_LOTTO_NUMERIC("로또는 숫자로 입력 해야 합니다."),
    INPUT_LOTTO_DUPLICATE("로또는 중복된 숫자가 있으면 안됩니다."),
    INPUT_BONUS_NUMBER_DUPLICATE("보너스 번호는 당첨 번호와 중복되면 안됩니다."),
    INPUT_BONUS_NUMBER_NUMERIC("보너스 번호는 숫자로 입력 해야 합니다."),
    INPUT_BONUS_NUMBER_RANGE("보너스 번호는 1 ~ 45 사이의 숫자로 입력 해야 합니다."),
    INPUT_LOTTO_RANGE("당첨 번호는 1 ~ 45 사이의 숫자로 입력 해야 합니다.");

    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
