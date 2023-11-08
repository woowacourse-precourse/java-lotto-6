package lotto.constants;

public enum ViewMessage {
    INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    PURCHASED_TICKETS("%d개를 구매했습니다."),
    INPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    MATCH_EXCEPT_BONUS("%d개 일치 (%,d원) - %d개"),
    MATCH_INCLUDE_BONUS("5개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    TOTAL_PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String message;

    ViewMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }

    public String format(Object... args) {
        return String.format(this.message, args);
    }
}