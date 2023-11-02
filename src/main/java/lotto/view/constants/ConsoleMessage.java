package lotto.view.constants;

public enum ConsoleMessage {

    // request
    ENTER_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    ENTER_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    ENTER_BONUS_NUMBER("보너스 번호를 입력해 주세요."),

    // response
    SUCCESS_PURCHASE_LOTTO("%d개를 구매했습니다."),
    RESULTS_SUMMARY("당첨 통계"),
    LOTTO_NUMBER_MATCH("%d개 일치 (%s원) - %d개"),
    LOTTO_NUMBER_MATCH_WITH_BONUS_NUMBER("%d개 일치, 보너스 볼 일치 (%s원) - %d개"),
    TOTAL_RETURN("총 수익률은 %.1f%%입니다."),

    // separator
    RESULT_SUMMARY_SEPARATOR("---"),
    WINNING_NUMBERS_SEPARATOR(","),

    // error
    PURCHASE_AMOUNT_ERROR("[ERROR] 1000원 단위의 금액을 입력해 주세요."),
    WINNING_NUMBERS_ERROR("[ERROR] 1~45 사이의 숫자를 공백 없이 %s로 구분하여 입력해 주세요."),
    BONUS_NUMBER_ERROR("[ERROR] 1~45 사이의 숫자를 입력해 주세요.");

    private final String message;

    ConsoleMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
