package lotto.controller;

import lotto.LottoResult;
import lotto.WinningLotto;
import lotto.model.Budget;
import lotto.model.Lotto;
import lotto.model.ProfitStats;
import lotto.model.TotalResult;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.view.InputView.*;

public class AppController {
    public Budget createBudget() {
        while (true) {
            try {
                printPurchasePrompt();
                return new Budget(readLine());
            } catch (IllegalArgumentException | IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public WinningLotto createWinningLotto() {
        while (true) {
            try {
                printWinningNumbersPrompt();
                String numbersStr = readLine();
                printBonusNumberPrompt();
                String bonusNumberStr = readLine();

                return new WinningLotto(numbersStr, bonusNumberStr);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public TotalResult processLottoResult(WinningLotto win, List<Lotto> lottos) {
        TotalResult totalResult = new TotalResult();
        for (Lotto lotto : lottos) {
            LottoResult result = win.getLottoResult(lotto);
            if (result != null) {
                totalResult.add(result);
            }
        }

        return totalResult;
    }

    public ProfitStats createProfitStats(Budget budget, TotalResult totalResult) {
        int totalProfit = 0;
        for (LottoResult type : LottoResult.values()) {
            totalProfit += type.multiplePrize(totalResult.get(type));
        }
        double rate = (double) (totalProfit) / budget.getBudget() * 100;

        return new ProfitStats(totalProfit, rate);
    }
}
