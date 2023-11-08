package lotto.controller;

import lotto.config.LottoConfig;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Quantity;
import lotto.domain.RandomLottoGenerator;
import lotto.domain.WinningLotto;
import lotto.exception.LottoException;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void run() {
        Quantity totalLotteries = makeQuantities();
        Lottos lottos = makeLottos(totalLotteries);
        WinningLotto winningLotto = makeWinningLotto();
        LottoResult result = LottoResult.of(lottos, winningLotto);
        showResultAndProfit(result);
        InputView.close();
    }

    private Quantity makeQuantities() {
        Quantity totalLotteries = Quantity.of(parseIntToMoney(), LottoConfig.PRICE);
        OutputView.printQuantityOfLotteries(totalLotteries);
        return totalLotteries;
    }

    private Money parseIntToMoney() {
        Money parsedMoney;
        while (true) {
            try {
                parsedMoney = new Money(InputView.printAskingBudget());
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return parsedMoney;
    }


    private Lottos makeLottos(Quantity totalLotteries) {
        Lottos lottos = Lottos.of(totalLotteries, new RandomLottoGenerator());
        OutputView.printBoughtLottos(lottos);
        return lottos;
    }

    private WinningLotto makeWinningLotto() {
        Lotto winningNumbers = parseListToLotto();
        BonusNumber bonusNumber = parseIntToBonusNumber(winningNumbers);
        return WinningLotto.of(winningNumbers, bonusNumber);
    }

    private Lotto parseListToLotto() {
        Lotto parsedLotto;
        while (true) {
            try {
                parsedLotto = new Lotto(InputView.printAskingWinningNumbers());
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return parsedLotto;
    }

    private BonusNumber parseIntToBonusNumber(Lotto winningNumbers) {
        BonusNumber parsedBonusNumber;
        while (true) {
            try {
                parsedBonusNumber = new BonusNumber(InputView.printAskingBonusNumber(), winningNumbers);
                break;
            } catch (LottoException e) {
                System.out.println(e.getMessage());
            }
        }
        return parsedBonusNumber;
    }

    private void showResultAndProfit(LottoResult result) {
        OutputView.printResult(result);
        OutputView.printProfit(result.calculateProfit());
    }

}
