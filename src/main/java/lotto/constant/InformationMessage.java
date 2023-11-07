package lotto.constant;

public enum InformationMessage {
    GUIDE_INPUT_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),

    PURCHASE_LOTTO_COUNT_FORMAT("%d개를 구매했습니다."),

    GUIDE_INPUT_WINNING_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    GUIDE_INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    WINNING_STATISTICS("당첨 통계"),
    SEPARATOR_LINE("---"),
    GENERAL_RANK_RESULT_FORMAT("%d개 일치 (%,d원) - %d개"),
    SECOND_RANK_RESULT_FORMAT("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    PROFIT_RATE_FORMAT("총 수익률은 %,.1f%%입니다."),
    ;

    private final String message;

    InformationMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}