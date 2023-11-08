package lotto.util;

public enum Instruction {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    INPUT_LOTTO_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    ERROR_INPUT_MONEY("[ERROR] 구입 금액으로 1000 이상의 수를 입력해 주세요."),
    ERROR_MULTIPLE_MONEY("[ERROR] 구입 금액으로 1000의 배수를 입력해 주세요."),
    ERROR_PROPERTY_LOTTO_TICKET_SIZE("[ERROR] 로또는 6개의 숫자로 구성되어야 합니다."),
    ERROR_DUPLICATE_LOTTO_NUMBER_EXISTENCE("[ERROR] 로또 번호는 중복될 수 없습니다."),
    ERROR_WRONG_LOTTO_NUMBER_RANGE("[ERROR] 1 이상 45 이하의 숫자를 입력해 주세요."),
    LOTTOS_SIZE_SUFFIX_MESSAGE("개를 구매했습니다.");

    private final String message;

    Instruction(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
