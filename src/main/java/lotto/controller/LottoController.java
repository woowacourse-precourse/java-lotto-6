package lotto.controller;

import lotto.Lotto;
import lotto.RandomLottoGenerator;
import lotto.config.LottoConfig;
import lotto.domain.BonusNumber;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Quantity;
import lotto.domain.WinningLotto;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView input;
    private final OutputView output;
    private final RandomLottoGenerator generator;

    public LottoController() {
        this.input = new InputView();
        this.output = new OutputView();
        this.generator = new RandomLottoGenerator();
    }

    public void run() {
        Quantity totalLotteries = Quantity.of(parseIntToMoney(), LottoConfig.PRICE);
        output.printQuantityOfLotteries(totalLotteries);
        Lottos lottos = Lottos.of(totalLotteries, generator);
        output.printBoughtLottos(lottos);
        Lotto winningNumbers = parseListToLotto();
        BonusNumber bonusNumber = parseIntToBonusNumber();
        WinningLotto winningLotto = WinningLotto.of(winningNumbers, bonusNumber);
        LottoResult result = LottoResult.of(lottos, winningLotto);
        output.printResult(result);
        output.printProfit(result.calculateProfit());
    }

    private Money parseIntToMoney() {
        return new Money(input.printAskingBudget());
    }

    private Lotto parseListToLotto() {
        return new Lotto(input.printAskingWinningNumbers());
    }

    private BonusNumber parseIntToBonusNumber() {
        return new BonusNumber(input.printAskingBonusNumber());
    }

}
