package lotto.controller;

import java.util.Arrays;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoFactory;
import lotto.domain.LottoBundle;
import lotto.domain.Money;
import lotto.domain.PurchasedLotto;
import lotto.domain.WinningNumbers;
import lotto.domain.number.RandomNumberGenerator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public void start() {
        purchasedLotto(inputMoney());
        winningLotto();
    }

    private void purchasedLotto(final Money inputMoney) {
        OutputView.printNewLine();
        PurchasedLotto purchasedLotto = new PurchasedLotto(inputMoney);
        LottoBundle lottoBundle = LottoFactory.createLottos(purchasedLotto.getBuyQuantity(), new RandomNumberGenerator());
        OutputView.printBuyQuantity(purchasedLotto);
        OutputView.printBuyLotto(lottoBundle);
        OutputView.printNewLine();
    }

    private WinningNumbers winningLotto() {
        Lotto winningLottoNumbers = getInputWinningLottoNumbers();
        OutputView.printNewLine();
        BonusNumber bonusLottoBonusNumber = getInputBonusLottoNumber();
        OutputView.printNewLine();
        return new WinningNumbers(winningLottoNumbers, bonusLottoBonusNumber);
    }

    private BonusNumber getInputBonusLottoNumber() {
        try {
            return BonusNumber.of(InputView.inputBonusLottoNumber());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputBonusLottoNumber();
        }
    }

    private static Money inputMoney() {
        try {
            return Money.of(InputView.inputMoney());
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return inputMoney();
        }
    }

    private static Lotto getInputWinningLottoNumbers() {
        try {
            String winningLottoNumbers = InputView.inputWinningLottoNumbers();
            return new Lotto(convertToIntegerList(winningLottoNumbers));
        } catch (IllegalArgumentException e) {
            OutputView.printErrorMessage(e);
            return getInputWinningLottoNumbers();
        }
    }

    private static List<Integer> convertToIntegerList(final String winningLottoNumbers) {
        String[] numbers = splitNumbers(winningLottoNumbers);
        return Arrays.stream(numbers)
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    private static String[] splitNumbers(final String winningLottoNumbers) {
        return winningLottoNumbers.split(",");
    }
}