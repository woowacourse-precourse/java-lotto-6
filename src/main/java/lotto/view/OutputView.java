package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    private final String PURCHASES_NUMBER = "개를 구매했습니다.";
    private final String WINNING_STATISTICS = "당첨 통계";
    private final String LINE = "---";
    private final String THREE = "3개 일치 (5,000원) - ";
    private final String FOUR = "4개 일치 (50,000원) - ";
    private final String FIVE = "5개 일치 (1,500,000원) - ";
    private final String FIVE_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private final String SIX = "6개 일치 (2,000,000,000원) - ";
    private final String SOME = "개";
    private int three;
    private int four;
    private int five;
    private int five_bonus;
    private int six;
    private int prizeCount;
    private int ALL_PRICE;

    public OutputView() {
        prizeCount = 0;
    }

    public void purchasesNumberView(int AMOUNT){
        System.out.println("\n" + AMOUNT + PURCHASES_NUMBER);
    }

    public void lottosView(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void winningStatistics(List<Integer> checkCount, int COUNT_LOTTO){
        System.out.println("\n" + WINNING_STATISTICS);
        System.out.println(LINE);

        threePrize(checkCount);

        fourPrize(checkCount);

        fivePrize(checkCount);

        fiveBonusPrize(checkCount);

        sixPrize(checkCount);

        yieldRateOfReturn(COUNT_LOTTO);
    }

    public int countPrize(List<Integer> checkCount, int Number){
        prizeCount = 0;
        for (int integer : checkCount) {
            if(integer == Number){
                prizeCount++;
            }
        }
        return prizeCount;
    }

    public void threePrize(List<Integer> checkCount){
        System.out.println(THREE + countPrize(checkCount, 3) + SOME);
        three = countPrize(checkCount, 3) * 5000;
    }

    public void fourPrize(List<Integer> checkCount){
        System.out.println(FOUR + countPrize(checkCount, 4) + SOME);
        four = countPrize(checkCount, 4) * 50000;
    }

    public void fivePrize(List<Integer> checkCount){
        System.out.println(FIVE + countPrize(checkCount, 5) + SOME);
        five = countPrize(checkCount, 5) * 1500000;
    }

    public void fiveBonusPrize(List<Integer> checkCount){
        System.out.println(FIVE_BONUS + countPrize(checkCount, 7) + SOME);
        five_bonus = countPrize(checkCount, 7) * 30000000;
    }

    public void sixPrize(List<Integer> checkCount){
        System.out.println(SIX + countPrize(checkCount, 6) + SOME);
        six = countPrize(checkCount, 6) * 200000000;
    }

    public void yieldRateOfReturn(int AMOUNT){
        System.out.println("총 수익률은 " + yieldCal(AMOUNT) + "%입니다.");
    }

    public double yieldCal(int AMOUNT){
        ALL_PRICE = three + four + five + five_bonus + six;
        return Math.round(((double)ALL_PRICE / AMOUNT * 100 * 100)) / 100.0;
    }
}