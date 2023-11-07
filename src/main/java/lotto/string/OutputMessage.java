package lotto.string;

public enum OutputMessage {
    REQUEST_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COUNT_MESSAGE("개를 구매했습니다."),
    REQUEST_WININGNUMBER_MESSAGE("당첨 번호를 입력해 주세요."),
    REQUEST_BONUSNUMBER_MESSAGE("보너스 번호를 입력해 주세요."),
    WININGSTATISTIC_START_MESSAGE("당첨 통계"),
    DIVISIONLINE_MESSAGE("---"),
    STATISTIC_FRONT_MESSAGE("개 일치 ("),
    STATISTIC_MIDDLE_MESSAGE("원) - "),
    STATISTIC_LAST_MESSAGE("개"),
    STATISTIC_RESULT_FRONT_MESSAGE("총 수익률은"),
    STATISTIC_RESULT_LAST_MESSAGE("%입니다."),
    ;

    OutputMessage(String s) {

    }
}
