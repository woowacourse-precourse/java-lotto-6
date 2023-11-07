package lotto.constants;

public enum PrintMessages {
    PROMPT_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PROMPT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    PROMPT_WINNING_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATICS_TOP_BANNER("당첨 통계", "---");

    public static final String NEW_LINE = System.lineSeparator();

    private final String message;

    PrintMessages(String message) {
        this.message = String.join("", message, System.lineSeparator());
    }

    PrintMessages(String... messages) {
        StringBuilder messageBuilder = new StringBuilder();
        for (String message : messages) {
            messageBuilder
                    .append(message)
                    .append(System.lineSeparator());
        }
        messageBuilder.append(System.lineSeparator());
        this.message = messageBuilder.toString();
    }

    public String getMessage() {
        return message;
    }

    public String getMessageWithNumber(Integer number) {
        return String.format(message, number);
    }
}
