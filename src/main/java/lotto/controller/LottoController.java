package lotto.controller;

import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;
    private static final int LOTTO_PRICE = 1000;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        LottoGenerator lottoGenerator = new LottoGenerator();
        outputView.inputPurchaseMoney();
        int price = inputView.inputPurchasePrice();
        outputView.printPurchaseNumber(price / LOTTO_PRICE);
        List<Lotto> lottos = lottoGenerator.lottoGenerator(price);
        outputView.printLottoNumbers(lottos);
        WinningLotto winningLotto = lottery();
        checkResult(lottos, winningLotto, price);
    }

    private WinningLotto lottery() {
        outputView.inputLottoNumber();
        Lotto lotto = new Lotto(inputView.inputLottoNumbers());
        outputView.inputBonusNumber();
        Bonus bonus = new Bonus(inputView.inputBonusNumber());
        WinningLotto winningLotto = new WinningLotto(lotto, bonus);
        return winningLotto;
    }

    private void checkResult(List<Lotto> lottos, WinningLotto winningLotto, int price) {
        ResultDiscriminator resultDiscriminator = new ResultDiscriminator(lottos, winningLotto);
        Map<Integer, Integer> resultMap = resultDiscriminator.checkPrize();
        outputView.printWinningStatistics();
        printResult(resultMap);
        int totalPrize = resultDiscriminator.checkTotalPrize(resultMap);
        outputView.printRateOfReturn(rateOfReturn(price, totalPrize));
    }

    private void printResult(Map<Integer, Integer> result) {
        outputView.printWinning5th(result.get(5));
        outputView.printWinning4th(result.get(4));
        outputView.printWinning3rd(result.get(3));
        outputView.printWinning2nd(result.get(2));
        outputView.printWinning1st(result.get(1));
    }

    private float rateOfReturn(int price, int totalPrize) {
        float rate = totalPrize / price * 100;
        return rate;
    }
}
