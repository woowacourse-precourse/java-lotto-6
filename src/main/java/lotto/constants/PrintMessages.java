package lotto.constants;

public enum PrintMessages {
    PROMPT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    PROMPT_WINNING_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATICS_TOP_BANNER("당첨 통계", "---");

    public static final String NEW_LINE = System.lineSeparator();

    private final String message;

    PrintMessages(String message) {
        this.message = message;
    }

    PrintMessages(String... messages) {
        StringBuilder messageBuilder = new StringBuilder();
        for (String message : messages) {
            messageBuilder
                    .append(message)
                    .append(System.lineSeparator());
        }
        this.message = messageBuilder.toString();
    }

    public String getMessageWithoutNewLine() {
        return message;
    }

    public String getMessage() {
        return String.join("", message, NEW_LINE);
    }
}
