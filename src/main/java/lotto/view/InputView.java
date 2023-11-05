package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.service.LottoService;
import lotto.validation.InputValidation;

public class InputView {
    public static int inputPurchaseAmount() {
        String input = Console.readLine();
        InputValidation.validatePurchaseAmountIsBlank(input);
        int purchaseInput = Integer.parseInt(input);
        InputValidation.validateInputPurchaseAmount(purchaseInput);
        InputValidation.validateInputString(input);
        return LottoService.amountPurchaseDivide(purchaseInput);
    }
}
