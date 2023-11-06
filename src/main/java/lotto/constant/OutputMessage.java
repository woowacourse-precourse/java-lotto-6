package lotto.constant;

public enum OutputMessage {
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    AFTER_INPUTTING_PURCHASE_AMOUNT("개를 구매했습니다."),
    INPUT_LOTTO_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_LOTTO_WINNING_STATISTICS("당첨 통계\n"
            + "---"),
    OUTPUT_LOTTO_5TH_PLACE("3개 일치 (5,000원) - "),
    OUTPUT_LOTTO_4TH_PLACE("4개 일치 (50,000원) - "),
    OUTPUT_LOTTO_3RD_PLACE("5개 일치 (1,500,000원) - "),
    OUTPUT_LOTTO_2ND_PLACE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_LOTTO_1ST_PLACE("6개 일치 (2,000,000,000원) - "),
    FINAL_OUTPUT("총 수익률은 %.2f%%입니다.");


    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public final String getMessage() {
        return message;
    }
}
