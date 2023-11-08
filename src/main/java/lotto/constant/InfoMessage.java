package lotto.constant;

public enum InfoMessage {
    REQUEST_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    ANNOUNCE_LOTTERIES_COUNT("개를 구매했습니다."),

    ANNOUNCE_TOTAL_PROFIT_START("총 수익률은 "),
    ANNOUNCE_TOTAL_PROFIT_END("%입니다.");



    private final String message;

    InfoMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
