package lotto.controller;

import lotto.model.Lotto;
import lotto.model.LottoResult;
import lotto.model.User;
import lotto.model.WinningNumber;
import lotto.utils.Util;
import lotto.view.InputView;
import lotto.view.OutputView;
import java.util.List;

public class LottoController {

    private static  User user;
    private static WinningNumber winningNumber;
    private static LottoResult lottoResult;

    public void run() {
        inputAmount();
        purchaseLotto();
        setWinningNumber();
        printLottoResult();
    }

    private void inputAmount() {
        try {
            int amount = InputView.inputAmount();
            user = User.from(amount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputAmount();
        }
    }

    private void purchaseLotto() {
        user.purchaseLottos();
        OutputView.printPurchasedLottos(user.getPurchasedLottos());
    }

    private void setWinningNumber() {
        Lotto winningNumbers = inputWinningNumber();
        inputBonusNumber(winningNumbers);
    }

    private Lotto inputWinningNumber() {
        try {
            String[] inputNumbers = InputView.inputWinningNumbers();
            List<Integer> numbers = Util.stringToIntegerList(inputNumbers);
            return Lotto.from(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNumber();
        }
    }

    private void inputBonusNumber(Lotto winningNumbers) {
        try {
            int bonusNumber = InputView.inputBonusNumber();
            winningNumber = WinningNumber.from(winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            inputBonusNumber(winningNumbers);
        }
    }

    private void printLottoResult() {
        lottoResult = new LottoResult(user, winningNumber);
        OutputView.printLottoResult(lottoResult.getLottoResult(user.getPurchasedLottos(), winningNumber));
        OutputView.printYield(lottoResult.getYield());
    }
}
