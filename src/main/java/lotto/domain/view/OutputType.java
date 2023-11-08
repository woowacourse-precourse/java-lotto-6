package lotto.domain.view;

public enum OutputType {
    INPUT_PURCHASE_AMOUNT_MESSAGE("구입금액을 입력해 주세요."),
    PURCHASE_COMPLETE_MESSAGE("개를 구매했습니다."),
    WINNING_NUMBER_INPUT_MESSAGE("당첨 번호를 입력해 주세요."),
    BONUS_NUMBER_INPUT_MESSAGE("보너스 번호를 입력해 주세요."),
    MATCH_3_MESSAGE("3개 일치 (5,000원) - "),
    MATCH_4_MESSAGE("4개 일치 (50,000원) - "),
    MATCH_5_MESSAGE("5개 일치 (1,500,000원) - "),
    MATCH_5_AND_BONUS_BALL_MESSAGE("5개 일치, 보너스 볼 일치 (30,000,000원) - "),
    MATCH_6_MESSAGE("6개 일치 (2,000,000,000원) - "),
    TOTAL_PROFIT_MESSAGE("6개 일치 (2,000,000,000원) - ");

    private final String value;

    OutputType(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }


}
