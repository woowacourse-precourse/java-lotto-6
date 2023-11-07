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
        Money money = getMoney();
        List<Lotto> lottos = generateLottos(money);
        WinLotto winLotto = getWinLotto();
        showResults(lottos, winLotto, money);
    }

    private Money getMoney() {
        while (true) {
            try {
                return Money.from(inputView.getPurchaseAmount());
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private List<Lotto> generateLottos(Money money) {
        while (true) {
            try {
                List<Lotto> lottos = lottoService.generateWith(money);
                outputView.print(lottos);
                return lottos;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private WinLotto getWinLotto() {
        while (true) {
            try {
                return lottoService.createWinLottoWith(
                        inputView.getWinLottoNumber(),
                        inputView.getBonusBall()
                );
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }

    private void showResults(List<Lotto> lottos, WinLotto winLotto, Money money) {
        LottoResult lottoResult = lottoService.calculateResult(lottos, winLotto);
        Profit profit = lottoService.calculateProfit(lottoResult, money);

        outputView.printResult(lottoResult);
        outputView.printProfit(profit);
    }
}
