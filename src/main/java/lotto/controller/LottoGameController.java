package lotto.controller;

import lotto.application.LottoService;
import lotto.application.ProfitCalculator;
import lotto.domain.LottoResult;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.WinningInfo;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class LottoGameController {

    private final LottoService lottoService;

    public LottoGameController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void lottoGame() {
        Money money = generateMoney();
        Lottos lottos = lottoService.purchaseLottos(money);
        OutputView.printMyLotto(lottos);
        WinningInfo winningInfo = generateWinningInfo();
        LottoResult lottoResult = lottoService.calculateLottoResult(lottos, winningInfo);
        OutputView.printWinningStatistics(lottoResult);
        double profit = ProfitCalculator.calculateProfitRate(money, lottoResult);
        OutputView.printProfit(profit);
    }

    private Money generateMoney() {
        try {
            int input = InputView.readPayMoney();
            return Money.of(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateMoney();
        }
    }

    private WinningInfo generateWinningInfo() {
        List<Integer> winningNumbers = generateWinningNumbers();
        int bonusNumber = generateBonusNumber();
        try {
            return WinningInfo.from(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateWinningInfo();
        }
    }

    private List<Integer> generateWinningNumbers() {
        try {
            return InputView.readWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateWinningNumbers();
        }
    }

    private int generateBonusNumber() {
        try {
            return InputView.readBonusNumber();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return generateBonusNumber();
        }
    }
}
