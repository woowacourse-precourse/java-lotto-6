package lotto.message;

public enum GuideMessage {
    GET_PAYMENT_REQUEST_MESSAGE("구입금액을 입력해 주세요."),
    GET_TARGET_NUMBERS_REQUEST_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_REQUEST_MESSAGE("보너스 번호를 입력해 주세요."),
    SHOW_LOTTOS_INFO_MESSAGE("%d개를 구매했습니다."),
    WINNING_RESULT_MESSAGE("당첨 통계\n---\n"),
    RATE_OF_PROFIT_MESSAGE("총 수익률은 %s%%입니다.");

    private String content;

    GuideMessage(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return this.content;
    }
}
