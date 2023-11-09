package lotto;

import java.text.DecimalFormat;
import java.util.List;

public class LottoPrinter {
    static final int INITIALIZE = 0;
    static final int DIGIT_FOR_ROUND_UP = 1000;
    static final double DIGIT_FOR_PRINT = 10.0;

    public void printLotteryList(List<Lotto> totalLottery) {
        System.out.println();
        System.out.println(totalLottery.size() + "개를 구매했습니다.");
        for (Lotto lottery : totalLottery) {
            lottery.printLotteryNumber();
        }
    }

    public void printWinningInformation(List<Ranking> winningInformation, int userMoney) {
        System.out.println();
        System.out.println("당첨 통계");
        System.out.println("---");

        System.out.println(Ranking.FIFTH_PRIZE.getSameNumberCount() + "개 일치 (" + splitMoneyBy1000(Ranking.FIFTH_PRIZE.getProfit()) + "원) - " + getPrizeCount(winningInformation, Ranking.FIFTH_PRIZE.getRank()) + "개");
        System.out.println(Ranking.FOURTH_PRIZE.getSameNumberCount() + "개 일치 (" + splitMoneyBy1000(Ranking.FOURTH_PRIZE.getProfit()) + "원) - " + getPrizeCount(winningInformation, Ranking.FOURTH_PRIZE.getRank()) + "개");
        System.out.println(Ranking.THIRD_PRIZE.getSameNumberCount() + "개 일치 (" + splitMoneyBy1000(Ranking.THIRD_PRIZE.getProfit()) + "원) - " + getPrizeCount(winningInformation, Ranking.THIRD_PRIZE.getRank()) + "개");
        System.out.println(Ranking.SECOND_PRIZE.getSameNumberCount() + "개 일치, 보너스 볼 일치 (" + splitMoneyBy1000(Ranking.SECOND_PRIZE.getProfit()) + "원) - " + getPrizeCount(winningInformation, Ranking.SECOND_PRIZE.getRank()) + "개");
        System.out.println(Ranking.FIRST_PRIZE.getSameNumberCount() + "개 일치 (" + splitMoneyBy1000(Ranking.FIRST_PRIZE.getProfit()) + "원) - " + getPrizeCount(winningInformation, Ranking.FIRST_PRIZE.getRank()) + "개");
        System.out.println("총 수익률은 " + getRateOfReturn(winningInformation, userMoney) + "%입니다.");
    }

    private String splitMoneyBy1000(int money) {
        DecimalFormat moneyConverter = new DecimalFormat("###,###");

        return moneyConverter.format(money);
    }

    private int getPrizeCount(List<Ranking> winningInformation, int rank) {
        int prizeCount = INITIALIZE;

        for (Ranking ranking : winningInformation) {
            if (ranking.getRank() == rank) {
                prizeCount++;
            }
        }

        return prizeCount;
    }

    private double getRateOfReturn(List<Ranking> winningInformation, int userMoney) {
        double revenue = INITIALIZE;

        for (Ranking ranking : winningInformation) {
            revenue += ranking.getProfit();
        }

        double rateOfReturn = revenue / userMoney;

        return Math.round(rateOfReturn * DIGIT_FOR_ROUND_UP) / DIGIT_FOR_PRINT;
    }
}