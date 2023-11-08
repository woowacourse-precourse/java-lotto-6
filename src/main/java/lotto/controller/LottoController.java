package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Storage.LottoStorage;
import lotto.model.WinningNumbers;
import lotto.utils.ResultOutput;
import lotto.utils.UserInput;
import lotto.utils.Validator;

public class LottoController {
    private int amount;

    public void startLottoController() {
        LottoStorage purchaseLotto = initPurchaseLotto();
        WinningNumbers winningLotto = new WinningNumbers(initWinningLotto(), initBonus());
        WinningResult lottoResult = new WinningResult(winningLotto, purchaseLotto);

        ResultOutput.printLottoResult(lottoResult);
        getProfit(lottoResult);
    }

    private void getProfit(WinningResult lottoResult) {
        double profit = lottoResult.calculateProfitRate(amount);
        ResultOutput.printProfit(profit);
    }

    private int initLottoQuantity() {
        amount = Integer.parseInt(UserInput.readPurchaseAmount());

        Validator.validateAmountRange(amount);
        Validator.validateUnit(amount);
        return amount / 1000;
    }

    private LottoStorage initPurchaseLotto() {
        NumberGenerator generateRandomNumbers = new NumberGenerator();
        List<Lotto> lottos = new ArrayList<>();

        int quantity = initLottoQuantity();
        for (int i = 0; i < quantity; i++) {
            lottos.add(new Lotto(generateRandomNumbers.generate()));
        }
        LottoStorage purchaseLottos = new LottoStorage(lottos);

        ResultOutput.printPurchaseQuantityMessage(quantity);
        ResultOutput.printPurchaseLotto(purchaseLottos.toString());
        return purchaseLottos;
    }

    private Lotto initWinningLotto() {
        String winning = UserInput.readWinningNumbers();
        return new Lotto(transformInputNumbers(winning));
    }

    private List<Integer> transformInputNumbers(String winningNumbers) {
        List<String> numbers = UserInput.splitNumbers(winningNumbers);

        Validator.validateNonNumericNumbers(numbers);
        return UserInput.convertToNumbers(numbers);
    }

    private int initBonus() {
        int bonus = Integer.parseInt(UserInput.readBonusNumber());

        Validator.validateLottoNumberRange(bonus);
        return bonus;
    }
}
