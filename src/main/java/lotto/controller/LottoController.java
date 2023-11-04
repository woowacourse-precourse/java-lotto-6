package lotto.controller;

import lotto.domain.generator.SixNumberGenerator;
import lotto.domain.model.Lotto;
import lotto.domain.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public void run() {
        int countOfLotto = buyLotto();

        OutputView.showCountOfLotto(countOfLotto);
        List<Lotto> lotteries = new ArrayList<>();

        for (int i = 0; i < countOfLotto; i++) {
            lotteries.add(issueLotto());
        }

        showLotteries(lotteries);
    }

    public int buyLotto() {
        boolean existInputFlag = false;
        boolean numericInputFlag = false;

        String inputValue = InputView.inputMoney();

        try {
            Validator.validateExistValue(inputValue);
            int inputMoney = Validator.validateNumericInput(inputValue);
            int countOfLotto = Validator.validateDivisibleBy1000(inputMoney);

            return countOfLotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.buyLotto();
        }
    }

    public Lotto issueLotto() {
        Lotto lotto = null;
        try {
            lotto = new Lotto(SixNumberGenerator.getRandomSixNumbers());

            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e);

            return this.issueLotto();
        }
    }

    public void showLotteries(List<Lotto> lotteries) {
        for (Lotto lotto : lotteries) {
            lotto.showNumbers();
        }
    }
}
