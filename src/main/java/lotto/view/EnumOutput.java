package lotto.view;

public enum EnumOutput {
    REQUEST_BUY_MONEY("구입금액을 입력해 주세요."),
    REQUEST_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    REQUEST_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    PRINT_NUMBER_OF_LOTTO("개를 구매했습니다."),
    PRINT_RANK_1("6개 일치 (2,000,000,000원) - "),
    PRINT_RANK_2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    PRINT_RANK_3("5개 일치 (1,500,000원) - "),
    PRINT_RANK_4("4개 일치 (50,000원) - "),
    PRINT_RANK_5("3개 일치 (5,000원) - "),
    PRINT_EARNINGS_RATE("총 수익률은 ");

    private final String MESSAGE;

    EnumOutput(String message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE;
    }
}
