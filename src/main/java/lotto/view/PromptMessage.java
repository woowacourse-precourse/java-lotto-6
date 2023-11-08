package lotto.view;

public enum PromptMessage {
    INPUT_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASE_NUMBERS_OF_LOTTO("%d개를 구매했습니다."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("""
            당첨 통계
            ---"""),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다.");

    private final String message;

    PromptMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
