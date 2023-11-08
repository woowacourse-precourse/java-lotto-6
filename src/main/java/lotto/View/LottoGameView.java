package lotto.View;

import lotto.Domain.Lotto;
import lotto.Domain.Prize;

import java.util.List;
import java.util.Map;

public class LottoGameView {
    public void displayNumberOfTickets(int numTickets) {
        System.out.println(numTickets + "개를 구매했습니다.");
    }
    public static final String WINNING_STATS_MESSAGE = "당첨 통계";
    public static final String CONTOUR = "---";
    public static final String WINNING_CONTOUR = " - ";
    public static final String WINNING_UNIT = "개";
    public static final String RATE_OF_RETURN_FRONT_MESSAGE = "총 수익률은 ";
    public static final String RATE_OF_RETURN_BACK_MESSAGE = "%입니다.";
    public static final String LINE_BREAK = "\r";

    public void displayTickets(List<Lotto> tickets) {
        for (Lotto lotto : tickets) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void showWinning(Map<Integer, Integer> results) {
        System.out.println(WINNING_STATS_MESSAGE);
        System.out.println(CONTOUR);
        System.out.println(Prize.FIFTH_PLACE.getMessage() + WINNING_CONTOUR + Prize.FIFTH_PLACE.getCount()+ WINNING_UNIT);
        System.out.println(Prize.FOURTH_PLACE.getMessage() + WINNING_CONTOUR + Prize.FOURTH_PLACE.getCount() + WINNING_UNIT);
        System.out.println(Prize.THIRD_PLACE.getMessage() + WINNING_CONTOUR + Prize.THIRD_PLACE.getCount() + WINNING_UNIT);
        System.out.println(Prize.SECOND_PLACE.getMessage() + WINNING_CONTOUR + Prize.SECOND_PLACE.getCount()+ WINNING_UNIT);
        System.out.println(Prize.FIRST_PLACE.getMessage() + WINNING_CONTOUR + Prize.FIRST_PLACE.getCount() + WINNING_UNIT);
    }
    /*
    public void displayResults(Map<Integer, Integer> results) {
        System.out.println("당첨 통계");
        System.out.println("---");
        for (int i = 3; i <= 5; i++) {
            int prizeMoney = getPrizeMoney(i);
            int count = results.getOrDefault(i, 0);
            System.out.println(i + "개 일치 (" + prizeMoney + "원) - " + count + "개");
        }
        int count = results.getOrDefault(7, 0);
        System.out.println(Prize.SECOND_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(1) + WINNING_UNIT);
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + count + "개");
        count = results.getOrDefault(6, 0);
        System.out.println(Prize.FIRST_PLACE.getMessage() + WINNING_CONTOUR + numberOfWinningTypes.get(0) + WINNING_UNIT);
        System.out.println("6개 일치 (2,000,000,000원) - " + count + "개");
    }*/
    public void displayTotalRevenueRate(double revenueRate) {
        System.out.println("총 수익률은 " + String.format("%.1f", revenueRate) + "%입니다.");
    }

    private int getPrizeMoney(int matchingNumbers) {
        if (matchingNumbers == 3) {
            return 5000;
        }
        if (matchingNumbers == 4) {
            return 50000;
        }
        if (matchingNumbers == 5) {
            return 1500000;
        }

        return 0;
    }



}
