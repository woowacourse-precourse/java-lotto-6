package lotto.controller;

import lotto.generator.BonusNumberGenerator;
import lotto.generator.LottoGenerator;
import lotto.generator.WinningNumberGenerator;
import lotto.domain.model.BonusNumber;
import lotto.domain.model.Lotteries;
import lotto.domain.model.WinningNumber;
import lotto.domain.validator.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {
    static final LottoGenerator LOTTO_GENERATOR = new LottoGenerator();
    static final WinningNumberGenerator WINNING_NUMBER_GENERATOR = new WinningNumberGenerator();
    static final BonusNumberGenerator BONUS_NUMBER_GENERATOR = new BonusNumberGenerator();

    public void run() {
        int countOfLotto = buyLotto();
        OutputView.showCountOfLotto(countOfLotto);

        Lotteries lotteries = LOTTO_GENERATOR.run(countOfLotto);
        OutputView.showLotteries(lotteries);

        WinningNumber winningNumber = WINNING_NUMBER_GENERATOR.run();
        BonusNumber bonusNumber = BONUS_NUMBER_GENERATOR.run(winningNumber);

        Map<String, Integer> statistics = lotteries.produceStatistics(winningNumber, bonusNumber);
        OutputView.showStatics(statistics);
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

}
