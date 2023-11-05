package lotto.controller;

import lotto.dto.PurchaseResult;
import lotto.dto.WinningResult;
import lotto.model.*;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        Purchase purchase = lottoPurchaeByMoney(Integer.parseInt(inputView.inputMoney()));
        WinningNumbers winningNumbers = createWinningNumbers();
        LottResult(purchase,winningNumbers);
    }

    private Purchase lottoPurchaeByMoney(Integer money) {
        Lottos lottos = new Lottos();
        Purchase purchase = Purchase.purchase(lottos, money);

        PurchaseResult result = new PurchaseResult(purchase.getLottos(), purchase.getAvailableLotto());
        outputView.outputPurchaseLottos(result);
        return purchase;
    }

    private WinningNumbers createWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        String[] split = inputView.inputWinningNumbers().split(",");
        for (String s : split) {
            numbers.add(Integer.parseInt(s));
        }
        int i = Integer.parseInt(inputView.inputBonusNumber());
        WinningNumbers winningNumbers = new WinningNumbers(new Lotto(numbers), i);
        return winningNumbers;
    }

    private void LottResult(Purchase purchase, WinningNumbers winningNumbers) {
        LottoResult lottoResult = new LottoResult(purchase, winningNumbers);
        float rateResult = ((float) lottoResult.calculatePriceSum() * 100) / purchase.getMoney();
        WinningResult winningResult = new WinningResult(lottoResult.calculateRank(), rateResult);
        outputView.outputWinningResult(winningResult);
    }
}
