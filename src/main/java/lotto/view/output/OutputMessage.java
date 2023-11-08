package lotto.view.output;

public enum OutputMessage {

    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),

    INPUT_WINNING_LOTTERY_NUMBERS("당첨 번호를 입력해 주세요."),

    INPUT_BONUS_LOTTERY_NUMBER("보너스 번호를 입력해 주세요."),

    LOTTERY_WINNING_STATISTICS("당첨 통계 \n---"),

    CORRESPONDENCE_LOTTERY("%s (%s원) - %s개"),

    TOTAL_RETURN_RATE("총 수익률은 %.1f%%입니다."),

    PURCHASED_LOTTERY("%s개를 구매했습니다.");

    final String message;

    OutputMessage(String message) {
        this.message = message;
    }
}
