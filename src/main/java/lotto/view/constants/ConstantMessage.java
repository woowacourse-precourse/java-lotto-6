package lotto.view.constants;

public enum ConstantMessage {
    ASK_LOTTO_PURCHASE_AMOUNT("구입금액을 입력해 주세요."),
    DISPLAY_LOTTO_PURCHASE_COUNT("개를 구매했습니다."),
    ASK_WINNING_LOTTO_NUMBERS("당첨 번호를 입력해 주세요."),
    ASK_WINNING_LOTTO_BONUS_NUMBER("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS_MESSAGE("당첨 통계"),
    FIRST_RANKING_COUNT_MESSAGE("6개 일치 (2,000,000,000원) - "),
    SECOND_RANKING_COUNT_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    THIRD_RANKING_COUNT_MESSAGE("5개 일치 (1,500,000원) - "),
    FOURTH_RANKING_COUNT_MESSAGE("4개 일치 (50,000원) - "),
    FIFTH_RANKING_COUNT_MESSAGE("3개 일치 (5,000원) - ");

    private final String message;

    ConstantMessage(String message){
        this.message = message;
    }

    public String getMessage(){
        return message;
    }


}
