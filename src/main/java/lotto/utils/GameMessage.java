package lotto.utils;

public enum GameMessage {
    PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    BOUGHT_TICKETS("%d개를 구매했습니다."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계"),
    WINNING("%d개 일치 (%,d원) - %d개"),
    BONUS_WINNING("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    PROFIT_RATE("총 수익률은 %d.1f%%입니다");

    private String message;
    GameMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
