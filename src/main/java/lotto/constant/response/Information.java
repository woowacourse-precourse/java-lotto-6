package lotto.constant.response;

public enum Information {

    MONEY("구입금액을 입력해 주세요."),
    WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    NUMBER_PURCHASED("%d개를 구매했습니다."),
    WINNING_STATISTICS("당첨 통계"),
    PROFIT_RATE("총 수익률은 %s%%입니다.");

    private final String message;

    Information(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
