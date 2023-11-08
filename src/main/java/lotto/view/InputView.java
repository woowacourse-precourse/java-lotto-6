package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.view.contants.InputMessage;
import lotto.view.validation.InputValidator;

import java.util.Arrays;

public class InputView {

    public static double getPurchaseAmountFromInput() {
        System.out.println(InputMessage.PURCHASE_AMOUNT.getValue());
        String inputAmount = inputRemoveBlank(Console.readLine());
        InputValidator.validateBlank(inputAmount);
        InputValidator.validatePurchaseNumber(inputAmount);
        return Double.parseDouble(inputAmount);
    }

    public static Lotto getWinningLottoFromInput() {
        System.out.println(InputMessage.WINNING_LOTTO.getValue());
        String inputWinningLotto = inputRemoveBlank(Console.readLine());
        InputValidator.validateBlank(inputWinningLotto);
        return new Lotto(
                Arrays.stream(inputWinningLotto.split(",", -1))
                        .map(InputValidator::validateLottoNumberAndConvertToNumeric)
                        .toList()
        );
    }

    public static BonusNumber getBonusNumberFromInput() {
        System.out.println(InputMessage.BONUS.getValue());
        String inputBonusNumber = inputRemoveBlank(Console.readLine());
        InputValidator.validateBlank(inputBonusNumber);
        InputValidator.validateBonusNumber(inputBonusNumber);
        return new BonusNumber(Integer.parseInt(inputBonusNumber.trim()));
    }

    public static String inputRemoveBlank(String input) {
        return input.replace(" ", "");
    }
}
