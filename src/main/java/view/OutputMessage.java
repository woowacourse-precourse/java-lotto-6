/**
 * @Package_name : view
 * @Enum_name : OutputMessage
 * <p>
 * Create Date : 2023-11-07 Create User : 정은채
 */
package view;

public enum OutputMessage {

    LOTTO_BUY_MONEY("구입금액을 입력해 주세요.\n"),
    LOTTO_BUY_COMPLETE("개를 구매했습니다.\n"),
    LOTTO_NUM_REQUEST("당첨 번호를 입력해 주세요.\n"),
    BONUS_NUM_REQUEST("보너스 번호를 입력해 주세요.\n"),
    WIN_STATISTIC("당첨 통계\n"
            + "---\n"),
    WIN_STATISTIC_3("3개 일치 (5,000원) - "),
    WIN_STATISTIC_4("4개 일치 (50,000원) - "),
    WIN_STATISTIC_5("5개 일치 (1,500,000원) - "),
    WIN_STATISTIC_5_BONUS("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    WIN_STATISTIC_6("6개 일치 (2,000,000,000원) - "),
    WIN_STATISTIC_COUNT("개\n"),
    TOTAL_PROFIT_1("총 수익률은 "),
    TOTAL_PROFIT_2("%입니다."),
    NEXT_LINE("\n"),
    Error("[ERROR]");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    /**
     * Description : 출력용 메세지 반환
     *
     * @Method : getMessage()
     * @return : String
     */
    public String getMessage() {
        return this.message;
    }

}
