package lotto.constants;

public enum InputMessage implements Message {
    DEMAND_INPUT_BUDGET("구입금액을 입력해 주세요."),
    DEMAND_INPUT_WINNING_NUMBERS("당첨 번호를 입력해주세요."),
    ;

    private final String message;

    InputMessage(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
