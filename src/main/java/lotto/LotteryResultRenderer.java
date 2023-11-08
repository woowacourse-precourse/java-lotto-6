package lotto;

import java.util.ArrayList;
import java.util.List;

public class LotteryResultRenderer {

    public static void printResultSubject() {
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public static WinnerStatsData getLottoResult(List<List<Integer>> usernumbers, ArrayList<Integer> winnerNumbers, int bonusNumber) {
        WinnerStatsData data = new WinnerStatsData();

        for (int i = 0; i < usernumbers.size(); i++) {
            List<Integer> usernumber = usernumbers.get(i);
            WinningMatchCase c = matchOneLine(usernumber, winnerNumbers, bonusNumber);

            if(WinningMatchCase.MATCH_3_NUMBER.equals(c)) {
                data.increaseMatch3Numbers();
            }
            if(WinningMatchCase.MATCH_4_NUMBER.equals(c)) {
                data.increaseMatch4Numbers();
            }
            if(WinningMatchCase.MATCH_5_NUMBER.equals(c)) {
                data.increaseMatch5Numbers();
            }
            if(WinningMatchCase.MATCH_6_NUMBER.equals(c)) {
                data.increaseMatch6Numbers();
            }
            if(WinningMatchCase.MATCH_5A_NUMBER.equals(c)) {
                data.increaseMatch5NumbersWithBonus();
            }

        }

        return data;
    }


    public static WinningMatchCase matchOneLine(List<Integer> usernumber, ArrayList<Integer> winnerNumbers, int bonusNumber) {
        int matchcount = 0;
        for (int j = 0; j < usernumber.size(); j++) {
            int num = usernumber.get(j);
            if (winnerNumbers.contains(num)) {
                matchcount++;
            }
        }

        if (matchcount == 5 && usernumber.contains(bonusNumber)) {
            return WinningMatchCase.MATCH_5A_NUMBER;
        }


        return WinningMatchCase.getcase(matchcount);
    }

    public static void printStats(WinnerStatsData data) {
        System.out.println("3개 일치 (5,000원) - " + data.getMatch3Numbers() + "개");
        System.out.println("4개 일치 (50,000원) - " + data.getMatch4Numbers() + "개");
        System.out.println("5개 일치 (1,500,000원) - " + data.getMatch5Numbers() + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + data.getMatch5NumbersWithBonus() + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + data.getMatch6Numbers() + "개");
    }

    public static double calculateReturnRate(WinnerStatsData data, int totalSale) {
        int totalMoneyForWinner = data.getMatch3Numbers() * 5000 + data.getMatch4Numbers() * 50000 + data.getMatch5Numbers() * 1500000
                + data.getMatch6Numbers() * 2000000000 + data.getMatch5NumbersWithBonus() * 30000000;
        float a =  ((float) totalMoneyForWinner / totalSale) * 100;
        double aa = Math.round(a * 100.0) / 100.0;
        return aa;
    }

}
