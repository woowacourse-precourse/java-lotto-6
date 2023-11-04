package lotto.controller;

import lotto.domain.generator.SixNumberGenerator;
import lotto.domain.model.Lotto;
import lotto.domain.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    public List<Lotto> run() {
        int countOfLotto = buyLotto();
        List<Lotto> lotteries = new ArrayList<>();


        OutputView.showCountOfLotto(countOfLotto);

        for (int i = 0; i < countOfLotto; i++) {
            lotteries.add(issueLotto());
        }

        OutputView.showLotteries(lotteries);

        return lotteries;
    }

    private int buyLotto() {
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

    private Lotto issueLotto() {
        try {
            Lotto lotto = new Lotto(SixNumberGenerator.getRandomSixNumbers());

            return lotto;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            return this.issueLotto();
        }
    }

}
