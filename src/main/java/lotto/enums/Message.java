package lotto.enums;

public enum Message {
    ERROR_MSG("[ERROR] "),
    COMMA(","),
    INPUT_MONEY_MSG("구입금액을 입력해 주세요."),
    AMOUNT_OF_LOTTO_TICKETS_MSG("%d개를 구매했습니다.\n"),
    INPUT_WINNING_NUMBER_MSG("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER_MSG("보너스 번호를 입력해 주세요."),
    STATISTICS_INFORM("당첨 통계"),
    DISTINGUISH("---"),
    PRINT_STATISTICS("%s - %d개 \n"),
    PRINT_EARNING_RATE("총 수익률은 %.1f%%입니다."),
    CHECK_INPUT_MONEY_UNIT_MSG("1000원 단위로 입력해주세요."),
    CHECK_INPUT_MONEY_FIGURE_MSG("숫자만 입력가능합니다."),
    CHECK_WINNING_NUM_BLANK_MSG("입력하신 값 중에 공백이 존재합니다."),
    CHECK_WINNING_NUM_DUPLICATION_MSG("중복되지 않는 6개의 숫자를 입력해주세요."),
    CHECK_WINNING_NUM_RANGE_OVER_MSG("범위를 초과한 숫자를 입력하셨습니다. 로또 당첨 번호의 숫자 범위는 1 ~ 45 입니다."),
    CHECK_WINNING_NUM_AMOUNT_MSG("당첨 번호는 6개 입니다. 6개의 당첨 번호를 입력해주세요"),
    CHECK_BONUS_NUM_DUPLICATION_MSG("당첨 번호 중에 이미 존재하는 숫자 입니다. 당첨 번호와 중복되지 않는 숫자를 입력해주세요"),
    CHECK_BONUS_NUM_RANGE_OVER_MSG("범위를 초과한 숫자를 입력하셨습니다. 보너스 번호의 숫자 범위는 1 ~ 45 입니다.");

    private final String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
