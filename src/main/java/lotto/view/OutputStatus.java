package lotto.view;

public enum OutputStatus {
    BUY_LOTTO_TICKET("구입금액을 입력해 주세요."),
    GET_LOTTO_TICKET("개를 구매했습니다."),
    NUMBERS_LOTTO("당첨 번호를 입력해 주세요"),
    BONUS_LOTTO("보너스 번호를 입력해 주세요"),
    RESULT_LOTTO("당첨 통계\n---"),
    RESULT_LOTTO_COUNT("개 일치"),
    RESULT_EARNINGS("총 수익률은"),
    RESULT_EARNINGS_PERCENT("%입니다.");

    private final String outputEnum;

    OutputStatus(String outputEnum) {
        this.outputEnum = outputEnum;
    }

    public String get() {
        return outputEnum;
    }
}
