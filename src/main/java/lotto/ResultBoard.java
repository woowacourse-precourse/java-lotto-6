package lotto;

import java.util.HashMap;
import java.util.List;
import lotto.purchasing.Generator;
import lotto.purchasing.Printer;
import lotto.purchasing.PurchaseAmount;
import lotto.winning.Analyst;
import lotto.winning.BonusNumber;
import lotto.winning.Prize;
import lotto.winning.PrizeIndex;
import lotto.winning.PrizeRankChecker;
import lotto.winning.WinningNumbers;

public class ResultBoard implements Showable {
    private static final int COUNT = PrizeIndex.COUNT.getNumber();

    PurchaseAmount purchaseAmount;
    Printer printer;
    WinningNumbers winningNumbers;
    BonusNumber bonusNumber;
    PrizeRankChecker prizeRankChecker;
    Analyst analyst;

    public ResultBoard(PurchaseAmount purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
        this.printer = new Printer(new Generator(purchaseAmount));
        this.winningNumbers = new WinningNumbers();
        this.bonusNumber = new BonusNumber();
        this.prizeRankChecker = new PrizeRankChecker();
        this.analyst = new Analyst();
    }

    @Override
    public void show() {
        List<Lotto> lottos = printer.print();

        HashMap<Prize, List<Integer>> updatedPrizes = analyst.updatePrizes(
                prizeRankChecker.computeMatchedNumberCounts(lottos, winningNumbers.ask()),
                prizeRankChecker.computeMatchedNumberCounts(lottos, List.of(bonusNumber.ask())));

        double returnRatio = analyst.calculateReturnRatio(updatedPrizes, Integer.parseInt(purchaseAmount.getInput()));

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + updatedPrizes.get(Prize.FIFTH).get(COUNT) + "개");
        System.out.println("4개 일치 (50,000원) - " + updatedPrizes.get(Prize.FOURTH).get(COUNT) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + updatedPrizes.get(Prize.THIRD).get(COUNT) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + updatedPrizes.get(Prize.SECOND).get(COUNT) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + updatedPrizes.get(Prize.FIRST).get(COUNT) + "개");
        System.out.println("총 수익률은 " + returnRatio + "%입니다.");
    }
}
