package lotto.common;

public enum LottoCommonString {
    INPUT_LOTTO_BUY_NUMBER("구입금액을 입력해 주세요."),
    FORMAT_LOTTO_BUY_SUCCESS("%d개를 구매했습니다."),
    INPUT_WINNER_LOTTO_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    LOTTO_WINNER_STATUS("당첨 통계"),
    LOTTO_RESULT_LINE("---"),
    FORMAT_WINNER_TABLE_RESULT("%s (%s원) - %d개"),
    FORMAT_PROFIT_RATE("총 수익률은 %.1f%%입니다."),
    LOTTO_INPUT_DELIMITER(",");

    private final String message;

    private LottoCommonString(String message) {
        this.message = message;

    }

    public String getMessage() {
        return message;
    }
}
