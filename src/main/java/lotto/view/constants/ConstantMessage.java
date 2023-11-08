package lotto.view.constants;

public enum ConstantMessage {
    ASK_LOTTO_PURCHASE_AMOUNT("\n구입금액을 입력해 주세요.\n"),
    DISPLAY_LOTTO_PURCHASE_COUNT("개를 구매했습니다.\n"),
    ASK_WINNING_LOTTO_NUMBERS("\n당첨 번호를 입력해 주세요.\n"),
    ASK_WINNING_LOTTO_BONUS_NUMBER("\n보너스 번호를 입력해 주세요.\n"),
    WINNING_STATISTICS_MESSAGE("\n당첨 통계\n---"),
    FIRST_RANKING_COUNT_MESSAGE("\n6개 일치 (2,000,000,000원) - "),
    SECOND_RANKING_COUNT_MESSAGE("\n5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_RANKING_COUNT_MESSAGE("\n5개 일치 (1,500,000원) - "),
    FOURTH_RANKING_COUNT_MESSAGE("\n4개 일치 (50,000원) - "),
    FIFTH_RANKING_COUNT_MESSAGE("\n3개 일치 (5,000원) - ");

    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }


}
