package lotto.controller;

import lotto.model.Lotto;
import lotto.service.Calculator;
import lotto.service.InputProcess;
import lotto.service.LottoNumberGenerator;
import lotto.service.LottoValidator;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {
    InputProcess inputProcess = new InputProcess();
    Calculator calculator = new Calculator();
    LottoValidator validator = new LottoValidator();
    LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
    OutputView outputView = new OutputView();

    public String getInputOfPurchaseAmount() {
        return inputProcess.getPurchaseAmount();
    }

    public int savePurchaseAmount() {
        String purchaseAmount = null;
        boolean check = false;
        while (!check) {
            purchaseAmount = getInputOfPurchaseAmount();
            check = validator.checkPurchaseAmountInput(purchaseAmount);
        }
        return Integer.parseInt(purchaseAmount);
    }

    public int getNumberOfLotto(int purchaseAmount) {
        return calculator.calculateNumberOfLotto(purchaseAmount);
    }

    public List<List<Integer>> getLottoStorage() {
        List<List<Integer>> storage = new ArrayList<>();
        int numberOfLotto = getNumberOfLotto(savePurchaseAmount());

        int cnt = 0;
        while (cnt != numberOfLotto) {
            cnt += 1;
            Lotto lotto = new Lotto(lottoNumberGenerator.generateLottoNumber());
            storage.add(lotto.getNumbers());
        }
        return storage;
    }

    public void showLottos(List<List<Integer>> lottos) {
        outputView.setOutputPurchasedAmount(lottos.size());
        lottos.forEach(lotto -> System.out.println(lotto.toString()));
    }
}
