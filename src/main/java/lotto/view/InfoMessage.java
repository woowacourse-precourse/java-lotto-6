package lotto.view;

public enum InfoMessage {
    BUY("구입금액을 입력해 주세요."),
    HOW_MUCH("개를 구매했습니다."),
    WINNING_NUM("당첨 번호를 입력해 주세요."),
    BONUS_NUM("보너스 번호를 입력해 주세요."),
    INFO_RESULT("당첨 통계"),
    RESULT_5("3개 일치 (5,000원) - "),
    RESULT_4("4개 일치 (50,000원) - "),
    RESULT_3("5개 일치 (1,500,000원) - "),
    RESULT_2("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    RESULT_1("6개 일치 (2,000,000,000원) - "),
    EARNING_RATE("총 수익률은 입니다.");

    private String Message;

    InfoMessage(String message) {
        this.Message = message;
    }

    public String getMessage() {
        return Message;
    }
}
