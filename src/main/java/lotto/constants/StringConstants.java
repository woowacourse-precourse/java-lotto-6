package lotto.constants;

public enum StringConstants {
    INPUT_BUY_PRICE("구입 금액을 입력해주세요."),
    BUY_FORMAT_MESSAGE("%d개를 구매했습니다."),
    INPUT_WINNING_MESSAGE("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_MESSAGE("보너스 번호를 입력해 주세요."),
    WINNING_RESULT_MESSAGE("당첨 통계"),
    WINNING_RESULT_SEPARATOR("---"),
    MATCH_RESULT_MESSAGE("%d개 일치 (%,d원) - %d개"),
    MATCH_RESULT_WITH_BONUS_MESSAGE("%d개 일치, 보너스 볼 일치 (%,d원) - %d개"),
    MATCH_RESULT_PROFIT_RATE("총 수익률은 %.1f%%입니다"),
    ERROR_FORMAT_MESSAGE("[ERROR] %s"),
    ;

    final String message;
    StringConstants(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return message;
    }
}
