package lotto.util;

public enum ProgramMessage {
    MONEY_INPUT_GUIDE_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_LOTTO_NUM_MESSAGE("%d개를 구매했습니다.\n"),
    WIN_LOTTO_NUMBER_INPUT_GUIDE_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_GUIDE_MESSAGE("보너스 번호를 입력해 주세요."),
    WIN_RESULT_GUIDE_MESSAGE("당첨 통계\n---"),
    WIN_RESULT("%d 개 일치 (%s원) - %d개\n"),
    PROFIT_MESSAGE("총 수익률은 %.2f%입니다.");

    String message;

    private ProgramMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
