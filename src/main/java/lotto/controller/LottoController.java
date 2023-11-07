package lotto.controller;

import java.util.List;
import lotto.domain.LottoResult;
import lotto.domain.Profit;
import lotto.domain.WinLotto;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = createMoney();
        List<Lotto> lottos = createLottos(money);
        WinLotto winLotto = createWinLotto();
        showResults(lottos, winLotto, money);
    }

    private Money createMoney() {
        try {
            return lottoService.createMoney(inputView.getPurchaseAmount());
        } catch (IllegalArgumentException error) {
            outputView.printError(error.getMessage());
            return createMoney();
        }
    }

    private List<Lotto> createLottos(Money money) {
        List<Lotto> lottos = lottoService.createLottos(money);
        outputView.print(lottos);
        return lottos;
    }

    private WinLotto createWinLotto() {
        try {
            return lottoService.createWinLotto(inputView.getWinNumbers(), inputView.getBonus());
        } catch (IllegalArgumentException error) {
            outputView.printError(error.getMessage());
            return createWinLotto();
        }
    }

    private void showResults(List<Lotto> lottos, WinLotto winLotto, Money money) {
        LottoResult lottoResult = lottoService.calculateResult(lottos, winLotto);
        Profit profit = lottoService.calculateProfit(lottoResult, money);

        outputView.printResult(lottoResult);
        outputView.printProfit(profit);
    }
}
