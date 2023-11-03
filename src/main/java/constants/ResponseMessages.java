package constants;

import java.sql.SQLOutput;

public class ResponseMessages {
    public static String endBuyMessage(int count) {
        return count + "개를 구매했습니다.";
    }

    public static final String winStatsMessage = "당첨 통계";
    public static final String lineMessage = "---";

    public static void winMessage(int win, int count) {
        String message = "";
        if (win == 5)
            message = "3개 일치 (5,000원) - " + count + "개";
        else if (win == 4)
            message = "4개 일치 (50,000원) - " + count + "개";
        else if (win == 3)
            message = "5개 일치 (1,500,000원) - " + count + "개";
        else if (win == 2)
            message = "5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개";
        else if (win == 1)
            message = "6개 일치 (2,000,000,000원) - " + count + "개";
        System.out.println(message);
    }

    public static void profitMessage(double profit) {
        System.out.println("총 수익률은 " + profit + "입니다.");
    }

}
