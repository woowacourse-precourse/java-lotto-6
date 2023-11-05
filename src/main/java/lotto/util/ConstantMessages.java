package lotto.util;

public enum ConstantMessages {
    DEPOSIT_TICKET_MONEY("구입금액을 입력해 주세요."),
    COUNT_TICKET("개를 구매했습니다."),
    INPUT_ANSWER_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    TOTAL_RETURN("총 수익률은 %s입니다."),
    TOTAL_RETURN_FORMAT("%,.1f%%"),
    WINNING_STATISTICS("당첨 통계"),
    NONE_BONUS_RESULT_MESSAGE("%d개 일치 (%s) - %d개"),
    BONUS_RESULT_MESSAGE("%d개 일치, 보너스 볼 일치 (%s) - %d개"),
    INPUT_PARSER_CHAR(","),
    START_RESULT_OUTPUT("---"),
    SPACE(" ");

    private final String message;

    ConstantMessages (String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
