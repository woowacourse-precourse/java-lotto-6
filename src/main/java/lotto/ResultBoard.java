package lotto;

import static lotto.Messages.COUNT_UNIT;
import static lotto.Messages.DIVIDER_LINE;
import static lotto.Messages.THIRD_PRIZE;
import static lotto.Messages.SECOND_PRIZE;
import static lotto.Messages.FOURTH_PRIZE;
import static lotto.Messages.RETURN_RATIO_HEAD;
import static lotto.Messages.RETURN_RATIO_TAIL;
import static lotto.Messages.FIRST_PRIZE;
import static lotto.Messages.STATISTICS_TITLE;
import static lotto.Messages.FIFTH_PRIZE;
import static lotto.winning.Prize.FIRST;
import static lotto.winning.Prize.SECOND;
import static lotto.winning.Prize.THIRD;
import static lotto.winning.Prize.FOURTH;
import static lotto.winning.Prize.FIFTH;
import static lotto.winning.Tally.COUNT;

import camp.nextstep.edu.missionutils.Console;
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
        Console.close();
    }

    @Override
    public void show() {
        HashMap<Prize, HashMap<Tally, Integer>> updatedPrizes = proceedLottoGame();

        double returnRatio = analyst.calculateReturnRatio(updatedPrizes, Integer.parseInt(purchaseAmount.getInput()));

        System.out.println(formatResult(updatedPrizes, returnRatio));
    }

    private HashMap<Prize, HashMap<Tally, Integer>> proceedLottoGame() {
        List<Lotto> lottos = printer.print();

        return analyst.updatePrizes(
                prizeRankChecker.computeMatchedNumberCounts(lottos, winningNumbers.ask()),
                prizeRankChecker.computeMatchedNumberCounts(lottos, List.of(bonusNumber.ask())));
    }

    private String formatResult(HashMap<Prize, HashMap<Tally, Integer>> updatedPrizes, double returnRatio) {
        return STATISTICS_TITLE.getMessage() + "\n"
                + DIVIDER_LINE.getMessage() + "\n"
                + FIFTH_PRIZE.getMessage() + updatedPrizes.get(FIFTH).get(COUNT) + COUNT_UNIT.getMessage() + "\n"
                + FOURTH_PRIZE.getMessage() + updatedPrizes.get(FOURTH).get(COUNT) + COUNT_UNIT.getMessage() + "\n"
                + THIRD_PRIZE.getMessage() + updatedPrizes.get(THIRD).get(COUNT) + COUNT_UNIT.getMessage() + "\n"
                + SECOND_PRIZE.getMessage() + updatedPrizes.get(SECOND).get(COUNT) + COUNT_UNIT.getMessage() + "\n"
                + FIRST_PRIZE.getMessage() + updatedPrizes.get(FIRST).get(COUNT) + COUNT_UNIT.getMessage() + "\n"
                + RETURN_RATIO_HEAD.getMessage() + returnRatio + RETURN_RATIO_TAIL.getMessage();
    }
}
