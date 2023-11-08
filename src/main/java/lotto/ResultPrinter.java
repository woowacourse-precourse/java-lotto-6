package lotto;

import java.util.List;

public class ResultPrinter {
    private final ResultCalculator resultCalculator = new ResultCalculator();

    public void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printResult(WinningResult result, int lottoCount) {
        result.printResult();
    }

    public void printEarningsRate(WinningResult result, int lottoCount) {
        double earningsRate = resultCalculator.calculateEarningsRate(result, lottoCount);
        System.out.println("총 수익률은 " + (earningsRate * 100) + "%입니다.");
    }
}
