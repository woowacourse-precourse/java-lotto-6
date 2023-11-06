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



    public void purchasesNumberView(int AMOUNT){
        System.out.println("\n" + AMOUNT + PURCHASES_NUMBER);
    }

    public void lottosView(List<Lotto> lottos){
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void winningStatistics(){
        System.out.println("\n" + WINNING_STATISTICS);
        System.out.println(LINE);

        System.out.print(THREE);
        //개수 입력
        System.out.println(SOME);

        System.out.print(FOUR);
        //개수 입력
        System.out.println(SOME);

        System.out.print(FIVE);
        //개수 입력
        System.out.println(SOME);

        System.out.print(FIVE_BONUS);
        //개수 입력
        System.out.println(SOME);

        System.out.print(SIX);
        //개수 입력
        System.out.println(SOME);
    }

    public void yieldRateOfReturn(double YIELD){
        System.out.println("총 수익률은 " + YIELD + "%입니다.");
    }
}