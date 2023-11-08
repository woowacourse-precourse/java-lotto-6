package lotto.utils.constant;

public enum ProcessMessage {
    WINNING_RESULT("%n당첨 통계%n"),
    DIVISION_MARK("--%n"),
    GET_MONEY("구입금액을 입력해 주세요.%n"),
    GET_WINNING_NUMBER("%n당첨 번호를 입력해 주세요.%n"),
    GET_BONUS_NUMBER("%n보너스 번호를 입력해 주세요.%n");

    private final String message;

    ProcessMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
