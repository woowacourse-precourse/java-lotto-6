package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.HashMap;
import java.util.List;
import lotto.purchasing.Generator;
import lotto.purchasing.Printer;
import lotto.purchasing.PurchaseAmount;
import lotto.winning.Analyst;
import lotto.winning.BonusNumber;
import lotto.winning.Prize;
import lotto.winning.PrizeRankChecker;
import lotto.winning.ResultBoard;
import lotto.winning.Tally;
import lotto.winning.MainNumbers;

public class SequenceManager {
    private final PurchaseAmount purchaseAmount;
    private final MainNumbers mainNumbers;
    private final BonusNumber bonusNumber;
    private final PrizeRankChecker prizeRankChecker;
    private final Analyst analyst;
    private final ResultBoard resultBoard;

    public SequenceManager() {
        this.purchaseAmount = new PurchaseAmount();
        this.mainNumbers = new MainNumbers();
        this.bonusNumber = new BonusNumber();
        this.prizeRankChecker = new PrizeRankChecker();
        this.analyst = new Analyst();
        this.resultBoard = new ResultBoard();
    }

    public void proceed() {
        Integer totalPurchaseAmount = purchaseAmount.ask();

        Printer printer = new Printer(new Generator(totalPurchaseAmount));
        List<Lotto> lottos = printer.print();

        HashMap<Prize, HashMap<Tally, Integer>> updatedPrizes =
                analyst.updatePrizes(
                        prizeRankChecker.computeMatchedNumberCounts(lottos, mainNumbers.ask()),
                        prizeRankChecker.computeMatchedNumberCounts(lottos, List.of(bonusNumber.ask())));

        Console.close();

        double returnRatio = analyst.calculateReturnRatio(updatedPrizes, totalPurchaseAmount);

        resultBoard.show(updatedPrizes, returnRatio);
    }
}
