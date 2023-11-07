package lotto.config;

public enum LottoGameMessage {
    INPUT_GET_MONEY("구입금액을 입력해 주세요."),
    INPUT_WINNING_NUMBER("\n당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("\n보너스 번호를 입력해 주세요."),
    OUTPUT_PURCHASED_LOTTO_SIZE("\n%d개를 구매했습니다."),
    OUTPUT_WINNING_RESULTS("\n당첨 통계"),
    OUTPUT_WINNING_RESULTS_LINES("---"),
    OUTPUT_MATCHED("%d개 일치 (%s원) - %d개"),
    OUTPUT_MATCHED_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    OUTPUT_PROFIT_RATE("총 수익률은 %s%%입니다."),
    ;
    private final String message;

    LottoGameMessage(String message) {
        this.message = message;
    }

    public String message() {
        return message;
    }
}
