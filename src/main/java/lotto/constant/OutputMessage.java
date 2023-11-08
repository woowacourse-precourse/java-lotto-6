package lotto.constant;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    AFTER_INPUTTING_PURCHASE_AMOUNT("%d개를 구매했습니다."),
    INPUT_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_WINNING_STATISTICS("당첨 통계\n"
            + "---"),
    FINAL_OUTPUT("총 수익률은 %.1f%%입니다.");


    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
