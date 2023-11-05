package lotto.constant;

public enum OutputMessage {

    GET_MONEY_MESSAGE("구입금액을 입력해 주세요."),
    BOUGHT_LOTTO_PACK_MESSAGE("%d개를 구매했습니다."),
    GET_WINNING_NUMBERS_MESSAGE("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    LOTTO_RESULT_MESSAGE("당첨 통계\n---"),
    INCOME_RATE_MESSAGE("총 수익률은 %.1f%%입니다.");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
