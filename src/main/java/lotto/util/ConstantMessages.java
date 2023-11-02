package lotto.util;

public enum ConstantMessages {
    DEPOSIT_TICKET_MONEY("구입금액을 입력해 주세요."),
    COUNT_TICKET("개를 구매했습니다."),
    INPUT_ANSWER_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private final String message;

    ConstantMessages (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
