package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.BonusNumber;
import lotto.model.LottoProfit;
import lotto.model.LottoStore;
import lotto.model.Lottos;
import lotto.model.Money;
import lotto.model.WinningNumberChecker;
import lotto.utils.Rank;
import lotto.utils.StringParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Controller {
    private final InputView inputView;
    private Lottos lottos = new Lottos();
    private Money money;
    private Map<Rank, Integer> result;

    public Controller(InputView inputView) {
        this.inputView = inputView;
    }

    public void start() {
        processBuyingLotto();
        processCalculateResult();
        processProfit();
        inputView.close();
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

    private Map<Rank, Integer> getWinningResult(List<Integer> winning, BonusNumber bonus) {
        WinningNumberChecker winningNumberChecker =
                new WinningNumberChecker(winning, bonus.getBonus(), lottos);
        winningNumberChecker.checkWinningRankResult();
        return winningNumberChecker.getWinningRankResult();
    }

    private Money getMoney() {
        OutputView.printGetMoneyMessage();
        while (true) {
            try {
                return new Money(StringParser.parseStringToInt(inputView.getPurchaseMoneyInput()));
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }

    private List<Integer> getWinningNumber() {
        OutputView.printGetWinningNumberMessage();
        while (true) {
            try {
                return StringParser.parseStringToIntList(inputView.getWinningNumbersInput());
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }

    private BonusNumber getBonusNumber(List<Integer> winningNumbers) {
        OutputView.printGetBonusNumberMessage();
        while (true) {
            try {
                int bonus = StringParser.parseStringToInt(inputView.getBonusNumberInput());
                return new BonusNumber(bonus, winningNumbers);
            } catch (IllegalArgumentException e) {
                OutputView.printCommonString(e.getMessage());
            }
        }
    }
}
