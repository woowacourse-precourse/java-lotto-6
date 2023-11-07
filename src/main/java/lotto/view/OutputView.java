package lotto.view;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import lotto.domain.LottoPurchase;

public class OutputView {

    private final int lottoPurchase;
    private final List<List<Integer>> randomNumbers;

    private final List<Integer> lottoResult;

    private final double rateOfReturn;

    public OutputView(int lottoPurchase, List<List<Integer>> randomNumbers, List<Integer> lottoResult, List<Integer> totalProfit, double rateOfReturn) {
        this.lottoPurchase = lottoPurchase;
        this.randomNumbers = randomNumbers;
        this.lottoResult = lottoResult;
        this.rateOfReturn = rateOfReturn;
    }

    public void showRandomNumbers() {
        for(int i = 0; i < lottoPurchase; i++) {
            System.out.println(randomNumbers.get(i));
        }
    }

    public void showLottoResult() {
        int threeMatch = Collections.frequency(lottoResult, 3);
        int fourMatch = Collections.frequency(lottoResult, 4);
        int fiveMatch = Collections.frequency(lottoResult, 5);
        int sixMatch = Collections.frequency(lottoResult, 6);

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + threeMatch + "개" );
        System.out.println("4개 일치 (50,000원) - " + fourMatch + "개" );
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + fiveMatch + "개" );
        System.out.println("6개 일치 (2,000,000,000원) - " + sixMatch + "개" );
    }

    public void showRateOfReturn() {

        String rof = String.format("%.2f", rateOfReturn);
        System.out.println("총 수익률은 " + rof + "입니다.");
    }

}
