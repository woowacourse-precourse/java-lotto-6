package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoMatcher;
import lotto.domain.LottoResult;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;
import java.util.Map;

public class LottoController {

    private InputView inputView;
    private OutputView outputView;

    public LottoController(
            InputView inputView,
            OutputView outputView
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        int buyPrice = inputBuyCash();
        List<Lotto> lottos = LottoFactory.buyLotto(buyPrice);
        outputView.printLotto(lottos);

        Lotto winningLotto = inputWinningNumbers();
        int bonusNumber = inputView.inputBonusNumber();

        Map<LottoResult, Integer> matchResult = matchLottos(lottos, winningLotto.getNumbers(), bonusNumber);
        outputView.printResultMessage();
        printResult(buyPrice, matchResult);
    }

    private void printResult(int buyPrice, Map<LottoResult, Integer> matchResult) {
        int profit = 0;
        for(int grade = 5; grade > 0; grade--) {
            LottoResult lottoResult = LottoResult.of(grade);
            int count = matchResult.getOrDefault(lottoResult, 0);
            profit += lottoResult.getProfit() * count;
            outputView.printLottoResult(lottoResult, count);
        }
        outputView.printProfit((float) profit / buyPrice * 100);
    }

    private Map<LottoResult, Integer> matchLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        LottoMatcher lottoMatcher = new LottoMatcher(winningNumbers, bonusNumber);
        Map<LottoResult, Integer> matchResult = lottoMatcher.match(lottos);
        return matchResult;
    }

    private int inputBuyCash() {
        try {
            return inputView.inputBuyCash();
        } catch (Exception e) {
            outputView.printError(e);
            return inputBuyCash();
        }
    }

    public Lotto inputWinningNumbers() {
        try {
            return LottoFactory.createLotto(inputView.inputWinningNumbers());
        } catch (Exception e) {
            outputView.printError(e);
            return inputWinningNumbers();
        }
    }
}
