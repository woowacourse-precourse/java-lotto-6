package lotto.controller;

public class UserInputMessage {
    public static final String REQUEST_LOTTO_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    public static final String REQUEST_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    public static final String REQUEST_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    public static final String LOTTO_TICKETS_PURCHASED_MESSAGE = "%d개를 구매했습니다.";
    public static final String LOTTO_RESULTS_MESSAGE = "당첨 통계";
    public static final String DIVIDER = "---";

    public static final String MATCH_MESSAGE = "%d개 일치 (%s원) - %d개";
    public static final String MATCH_BONUS_MESSAGE = "%d개 일치, 보너스 볼 일치 (%s원) - %d개";

    private UserInputMessage() {
    }
}
