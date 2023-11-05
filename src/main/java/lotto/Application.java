package lotto;

import camp.nextstep.edu.missionutils.Console;

import lotto.purchasing.Generator;
import lotto.purchasing.Printer;
import lotto.purchasing.PurchaseAmount;
import lotto.winning.Analyst;
import lotto.winning.BonusNumber;
import lotto.winning.PrizeRankChecker;
import lotto.winning.WinningNumbers;

public class Application {
    public static void main(String[] args) {
        PurchaseAmount purchaseAmount = new PurchaseAmount();

        ResultBoard resultBoard =
                new ResultBoard(purchaseAmount,
                        new Printer(new Generator(purchaseAmount)),
                        new WinningNumbers(),
                        new BonusNumber(),
                        new PrizeRankChecker(),
                        new Analyst());

        resultBoard.show();

        Console.close();
    }
}
