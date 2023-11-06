package lotto.global.utils.constant;

public enum OutputType {

    OUTPUT_PURCHASE_PRICE("구입금액을 입력해 주세요."),
    OUTPUT_NUMBER_OF_PURCHASES("개를 구매했습니다."),
    OUTPUT_WINNING_NUMBERS("당첨 번호를 입력해 주세요."),
    OUTPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    OUTPUT_WINNING_STATISTICS("당첨 통계\n" + "---"),
    OUTPUT_WINNING_STATISTICS_5("3개 일치 (5,000원) - "),
    OUTPUT_WINNING_STATISTICS_4("4개 일치 (50,000원) - "),
    OUTPUT_WINNING_STATISTICS_3("5개 일치 (1,500,000원) - "),
    OUTPUT_WINNING_STATISTICS_2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    OUTPUT_WINNING_STATISTICS_1("6개 일치 (2,000,000,000원) - "),
    OUTPUT_RESULT_1("총 수익률은 "),
    OUTPUT_RESULT_2("%입니다."),

    OUTPUT_COUNT("개"),
    EMPTY(""),
    EXCEPTION_INPUT_RANGE("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    EXCEPTION_INPUT_LENGTH("[ERROR] 6자리의 로또 번호를 입력해야 합니다."),
    EXCEPTION_INPUT_REDUNDANT("[ERROR] 중복된 번호는 입력하실 수 없습니다."),
    EXCEPTION_INPUT_PRICE("[ERROR] 로또 구입 금액은 1000원 단위로 입력해야 합니다.");

    private final String comment;

    OutputType(final String comment) {
        this.comment = comment;
    }

    public String getComment() {
        return comment;
    }
}
