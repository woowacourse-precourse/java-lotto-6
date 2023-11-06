package lotto.etc;

public enum SystemConstant {

    START("구입금액을 입력해 주세요."),
    BUY("%s개를 구매했습니다.\n"),
    JACKPOT("당첨 번호를 입력해 주세요."),
    BONUS("보너스 번호를 입력해 주세요."),
    WINNING_STATISTICS("당첨 통계\n---"),
    THREE_SAME("3개 일치 (5,000원) - %s개\n"),
    FOUR_SAME("4개 일치 (50,000원) - %s개\n"),
    FIVE_SAMECONSTANT("5개 일치 (1,500,000원) - %s개\n"),
    FIVE_BONUS_SAMECONSTANT("5개 일치, 보너스 볼 일치 (30,000,000원) - %s개\n"),
    SIX_SAME("6개 일치 (2,000,000,000원) - %s개\n"),
    RATE_OF_RETURN("총 수익률은 %s%%입니다."),
    THREE_ZERO("000");

    private String enumString;
    SystemConstant(String enumStr) {
        enumString = enumStr;
    }
    @Override
    public String toString(){
        return enumString;
    }

}
