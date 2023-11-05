package lotto.settings;

import static lotto.settings.WinningAmount.*;

public enum WinningSettings {

//    3개 일치 (5,000원) - %s개
//4개 일치 (50,000원) - %s개
//5개 일치 (1,500,000원) - %s개
//5개 일치, 보너스 볼 일치 (30,000,000원) - %s개
//6개 일치 (2,000,000,000원) - %s개
    FIFTH_PLACE(String.format("3개 일치 (%s원) - ", FIRST.getPrize())),
    FOURTH_PLACE(String.format("4개 일치 (%s원) - ",SECOND.getPrize())),
    THIRD_PLACE(String.format("5개 일치 (%s원) - ",THIRD.getPrize())),
    SECOND_PLACE(String.format("5개 일치, 보너스 볼 일치 (%s원) - ",FOURTH.getPrize())),
    FIRST_PLACE(String.format("6개 일치 (%s원) - ",FIFTH.getPrize())),
    NOTHING("등수안에 들지 못했습니다."),
    RATE_OF_RETURN("총 수익률은 %.2f입니다.\n");

    private final String result;

    WinningSettings(String result) {
        this.result = result;
    }

    public String getResult() {
        return result;
    }
}
