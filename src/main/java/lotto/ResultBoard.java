package lotto;

import static lotto.winning.Prize.FIRST;
import static lotto.winning.Prize.SECOND;
import static lotto.winning.Prize.THIRD;
import static lotto.winning.Prize.FOURTH;
import static lotto.winning.Prize.FIFTH;
import static lotto.winning.Tally.COUNT;

import java.util.HashMap;
import java.util.List;
import lotto.purchasing.Generator;
import lotto.purchasing.Printer;
import lotto.purchasing.PurchaseAmount;
import lotto.winning.Analyst;
import lotto.winning.BonusNumber;
import lotto.winning.Prize;
import lotto.winning.Tally;
import lotto.winning.PrizeRankChecker;
import lotto.winning.WinningNumbers;

public class ResultBoard implements Showable {
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
        HashMap<Prize, HashMap<Tally, Integer>> updatedPrizes = proceedLottoGame();

        double returnRatio = analyst.calculateReturnRatio(updatedPrizes, Integer.parseInt(purchaseAmount.getInput()));

        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.println("3개 일치 (5,000원) - " + updatedPrizes.get(FIFTH).get(COUNT) + "개");
        System.out.println("4개 일치 (50,000원) - " + updatedPrizes.get(FOURTH).get(COUNT) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + updatedPrizes.get(THIRD).get(COUNT) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + updatedPrizes.get(SECOND).get(COUNT) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + updatedPrizes.get(FIRST).get(COUNT) + "개");
        System.out.println("총 수익률은 " + returnRatio + "%입니다.");
    }

    private HashMap<Prize, HashMap<Tally, Integer>> proceedLottoGame() {
        List<Lotto> lottos = printer.print();

        return analyst.updatePrizes(
                prizeRankChecker.computeMatchedNumberCounts(lottos, winningNumbers.ask()),
                prizeRankChecker.computeMatchedNumberCounts(lottos, List.of(bonusNumber.ask())));
    }
}
