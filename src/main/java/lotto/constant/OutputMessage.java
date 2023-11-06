package lotto.constant;

public enum OutputMessage {
    MESSAGE_OF_ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    MESSAGE_OF_AFTER_INPUTTING_PURCHASE_AMOUNT("개를 구매했습니다."),
    MESSAGE_OF_INPUT_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    MESSAGE_OF_INPUT_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    MESSAGE_OF_OUTPUT_LOTTO_WINNING_STATISTICS("당첨 통계\n"
            + "---");


    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
