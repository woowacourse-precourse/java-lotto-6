package lotto.string;

public enum OutputMessage {
    REQUEST_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    REQUEST_WININGNUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUSNUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WININGSTATISTIC_START_MESSAGE("당첨 통계"),
    DIVISIONLINE_MESSAGE("---"),
    RANK5_COUNT_MESSAGE("3개 일치 (5,000원) - "),
    RANK4_COUNT_MESSAGE("4개 일치 (50,000원) - "),
    RANK3_COUNT_MESSAGE("5개 일치 (1,500,000원) - "),
    RANK2_COUNT_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RANK1_COUNT_MESSAGE("6개 일치 (2,000,000,000원) - "),
    RANK_COUNT_UNIT_MESSAGE("개"),
    STATISTIC_RESULT_FRONT_MESSAGE("총 수익률은 "),
    STATISTIC_RESULT_LAST_MESSAGE("%입니다."),
    NEWLINE_MESSAGE("\n");
    private String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
