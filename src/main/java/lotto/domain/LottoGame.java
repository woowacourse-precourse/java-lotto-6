package lotto.domain;

import java.util.List;
import lotto.util.util;
import lotto.validate.InputValidation;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoGame {
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    InputValidation inputValidation = new InputValidation();
    Lottos lottos;
    WinningLottoNumbers winningLottoNumbers;
    Purchase purchase;

    public void game() {
        input();

        String winningNumber = inputWinningNumbers();
        util.lineBlank();

        String bonus = inputBonus(winningNumber);
        util.lineBlank();

        winningLottoNumbers = new WinningLottoNumbers(winningNumber,bonus);

        output(lottos.matchRanks(winningLottoNumbers));
    }

    public void input() {
        purchase = inputPurchase();

        util.lineBlank();
        outputView.printPurchaseQyantity(purchase.getQuantity());

        lottos = new Lottos(new LottosGenerator(purchase.getQuantity()).generateLottos());

        outputView.printLottoNumbers(lottos);
        util.lineBlank();
    }

    public void output(List<Rank> rankResult) {
        outputView.printwinningResultMessage();
        outputView.printResult(rankResult, purchase.getPurchase());
    }


    public Purchase inputPurchase() {
        try {
            inputView.printInputPurchaseAmountMessage();
            String purchaseAmount = inputView.inputPurchaseAmount();

            return new Purchase(purchaseAmount);
        } catch (IllegalArgumentException e) {
            util.println(e.getMessage());
            return inputPurchase();
        }
    }

    public String inputWinningNumbers() {
        try {
            inputView.printInputWinningNumberMessage();
            String inputWinningNumbers = inputView.inputWinningNumbers();
            inputValidation.validateWinningNumbers(inputWinningNumbers);

            return inputWinningNumbers;
        } catch (IllegalArgumentException e) {
            util.println(e.getMessage());
            return inputWinningNumbers();
        }
    }

    public String inputBonus(String winningNumber) {
        try {
            inputView.printInputBonusNumberMessage();
            String bonus = inputView.inputBounsNumber();
            inputValidation.validateBonusNumber(bonus, winningNumber);

            return bonus;
        } catch (IllegalArgumentException e) {
            util.println(e.getMessage());
            return inputBonus(winningNumber);
        }

    }
}
