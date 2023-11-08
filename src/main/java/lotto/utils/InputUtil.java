package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.validator.InputValidator;
import lotto.view.ErrorView;
import lotto.view.InputView;

public class InputUtil {
    private static String input() {
        return Console.readLine();
    }

    public static int inputLottoPrice() {
        InputView.inputLottoPriceMessage();

        try {
            String price = input();
            return InputValidator.validateLottoPriceInput(price);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return inputLottoPrice();
        }
    }

    public static WinningLotto inputWinningLotto() {
        try {
            Lotto lotto = inputLottoNumber();
            int bonusNumber = inputBonusNumber();
            return new WinningLotto(lotto, bonusNumber);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return inputWinningLotto();
        }
    }

    private static Lotto inputLottoNumber() {
        InputView.inputLottoNumber();

        try {
            String lottoNumber = input();
            List<Integer> winningLotto = InputValidator.validateLottoNumberInput(lottoNumber);
            return new Lotto(winningLotto);
        }
        catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return inputLottoNumber();
        }
    }

    private static int inputBonusNumber() {
        InputView.inputBonusNumber();

        try {
            String bonusNumber = input();
            return InputValidator.validateBonusNumberInput(bonusNumber);
        } catch (IllegalArgumentException e) {
            ErrorView.printErrorMessage(e.getMessage());
            return inputBonusNumber();
        }
    }
}
