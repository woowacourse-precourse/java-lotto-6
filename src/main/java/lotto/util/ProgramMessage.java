package lotto.util;

public enum ProgramMessage {
    MONEY_INPUT_GUIDE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO_NUM_MESSAGE("\n%d개를 구매했습니다.\n"),
    WIN_LOTTO_NUMBER_INPUT_GUIDE_MESSAGE("\n당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_GUIDE_MESSAGE("\n보너스 번호를 입력해 주세요."),
    WIN_RESULT_GUIDE_MESSAGE("\n당첨 통계\n---"),
    WIN_RESULT_WITHOUT_BONUS("%d개 일치 (%s원) - %d개\n"),
    WIN_RESULT_WITH_BONUS("%d개 일치, 보너스 볼 일치 (%s원) - %d개\n"),
    PROFIT_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    String message;

    ProgramMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
