package lotto.constant;

public enum OutputMessage {
    GET_PRICE_MSG("구입금액을 입력해 주세요."),
    BOUGHT_MSG("개를 구매했습니다."),
    GET_LOTTERY_NUMBER_MSG("당첨 번호를 입력해 주세요."),
    GET_BONUS_NUMBER_MSG("보너스 번호를 입력해 주세요."),
    PRINT_RESULT_MSG("당첨 통계"),
    SPLITTER("---"),
    MATCHES_3("3개 일치"),
    MATCHES_4("4개 일치"),
    MATCHES_5("5개 일치"),
    MATCHES_BONUS("5개 일치, 보너스 볼 일치"),
    MATCHES_6("6개일치"),
    EXCEPTION_PREFIX("[ERROR]");

    private final String msg;

    OutputMessage(String msg) {
        this.msg = msg;
    }


    @Override
    public String toString() {
        return this.msg;
    }
}