package lotto.settings;

public enum WinningSettings {

//    3개 일치 (5,000원) - %s개
//4개 일치 (50,000원) - %s개
//5개 일치 (1,500,000원) - %s개
//5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
//6개 일치 (2,000,000,000원) - %s개
    FIRST_PLACE("3개 일치 (%s원) - %s개\n"),
    SECOND_PLACE("4개 일치 (%s원) - %s개\n"),
    THIRD_PLACE("5개 일치 (%s원) - %s개\n"),
    FOURTH_PLACE("5개 일치, 보너스 볼 일치 (%s원) - %s개\n"),
    FIFTH_PLACE("6개 일치 (%s원) - %s개\n"),
    RATE_OF_RETURN("총 수익률은 %.2f입니다.\n");

    private final String result;

    WinningSettings(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
