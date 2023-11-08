package lotto.constant;

public enum SystemConstant {
    INPUT_MONEY_MESSAGE("구입금액을 입력해 주세요.\n"),
    INPUT_WINNING_NUMBER_MESSAGE("당첨 번호를 입력해 주세요.\n"),
    INPUT_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요.\n"),
    OUTPUT_LOTTO_BUY_COUNT_MESSAGE("%d개를 구매했습니다.\n"),
    OUTPUT_RESULT_MESSAGE("당첨 통계\n"),
    LINE("---\n"),
    OUTPUT_RESULT_COUNT_MESSAGE("%d개 일치 (%,d원) - %d개\n"),
    OUTPUT_BONUS_RESULT_COUNT_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개\n"),
    OUTPUT_RESULT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    SystemConstant(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
