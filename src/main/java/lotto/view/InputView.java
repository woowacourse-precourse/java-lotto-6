package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.system.LottoMessage;
import lotto.validation.AmountValidation;
import lotto.validation.BonusValidation;
import lotto.validation.LottoValidation;

public class InputView {
    private static AmountValidation amountValidation = new AmountValidation();
    private static LottoValidation lottoValidation = new LottoValidation();
    private static BonusValidation bonusValidation = new BonusValidation();

    public static int inputPurchaseAmount() {
        OutputView.printMessage(LottoMessage.INPUT_PURCHASE_AMOUNT_MESSAGE);
        String amount = Console.readLine();
        amountValidation.check(amount);
        return Integer.parseInt(amount);
    }

    public static List<Integer> inputLotto() {
        OutputView.printMessage(LottoMessage.INPUT_WINNING_NUMBERS_MESSAGE);
        String Lotto = Console.readLine();
        lottoValidation.check(Lotto);

        return Arrays.stream(Lotto.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    public static int inputBonusNumbers() {
        OutputView.printMessage(LottoMessage.INPUT_BONUS_NUMBER_MESSAGE);
        String Bonus = Console.readLine();
        bonusValidation.check(Bonus);

        return Integer.parseInt(Bonus);
    }
}
