package lotto.util;

public enum SystemMessage {

    AMOUNT_INPUT("구입금액을 입력해 주세요."),
    PURCHASE_NIO("개를 구매했습니다."),
    ANSWER_INPUT("당첨 번호를 입력해 주세요."),
    BONUS_INPUT("보너스 번호를 입력해 주세요."),
    RESULT_OUTPUT("당첨 통계"),
    RESULT_START("---"),
    THREE("3개 일치 (5,000원) - "),
    FOUR("4개 일치 (50,000원) - "),
    FIVE("5개 일치 (1,500,000원) - "),
    FIVEANDBONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    SIX("6개 일치 (2,000,000,000원) - "),
    EA("개"),
    TOTAL1("총 수익률은 "),
    TOTAL2("%입니다.");

    private final String message;

    SystemMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
