package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoProfit;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumberChecker;
import lotto.utils.StringParser;
import lotto.view.BonusNumberInputView;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.PurchaseCostInputView;
import lotto.view.WinningNumberInputView;

public class Controller {
    private InputView inputView;
    private Lottos lottos = new Lottos();
    private Money money;
    private Map<String, Integer> result;

    public void start() {
        processBuyingLotto();
        processCalculateResult();
        processProfit();
    }

    public void processBuyingLotto() {
        money = getMoney();
        OutputView.printLottoCount(money.getLottoCount());
        LottoStore lottoStore = new LottoStore(money.getLottoCount());
        lottos = lottoStore.buyLotto();
        OutputView.printCommonString(lottos.toString());
    }

    public void processCalculateResult() {
        List<Integer> winning = getWinningNumber();
        BonusNumber bonus = getBonusNumber(winning);
        result = getWinningResult(winning, bonus);
        OutputView.printWinningResult(result);
    }

    public void processProfit() {
        LottoProfit lottoProfit = new LottoProfit(result, money);
        OutputView.printLottoProfit(lottoProfit.getResult());
    }

    private Map<String, Integer> getWinningResult(List<Integer> winning, BonusNumber bonus) {
        WinningNumberChecker winningNumberChecker =
                new WinningNumberChecker(winning, bonus.getBonus(), lottos);
        winningNumberChecker.checkWinningRankResult();
        return winningNumberChecker.getWinningRankResult();
    }

    private Money getMoney() {
        OutputView.printGetMoneyMessage();
        while (true) {
            try {
                inputView = new PurchaseCostInputView();
                return new Money(StringParser.parseStringToInt(inputView.getUserInput()));
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumber() {
        OutputView.printGetWinningNumberMessage();
        while (true) {
            try {
                inputView = new WinningNumberInputView();
                return StringParser.parseStringToIntList(inputView.getUserInput());
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(List<Integer> winningNumbers) {
        OutputView.printGetBonusNumberMessage();
        while (true) {
            try {
                inputView = new BonusNumberInputView();
                int bonus = StringParser.parseStringToInt(inputView.getUserInput());
                return new BonusNumber(bonus, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }
}
