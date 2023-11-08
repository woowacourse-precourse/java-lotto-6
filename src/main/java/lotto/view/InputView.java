package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.Lotto;
import lotto.validator.InputValidator;

public class InputView {
    public static int inputPurchaseAmount() {
        int purchaseAmount = InputValidator.checkIsInteger(Console.readLine());
        InputValidator.validatePurchaseAmount(purchaseAmount);

        return purchaseAmount;
    }

    public static Lotto inputWinningLotto() {
        String numbers = Console.readLine();
        List<Integer> winningLotto = getLottoFormat(numbers);

        return new Lotto(winningLotto);
    }

    private static List<Integer> getLottoFormat(String numbers) {
        return InputValidator.validateLottoFormat(numbers);
    }

    public static int inputBonusNumber() {
        int bonus = InputValidator.checkIsInteger(Console.readLine());
        InputValidator.validateBonus(bonus);

        return bonus;
    }
}
