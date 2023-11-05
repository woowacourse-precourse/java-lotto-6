package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Collections;
import java.util.List;
import lotto.service.LottoService;
import lotto.validation.InputValidation;

public class InputView {
    public static int inputPurchaseAmount() {
        String input = Console.readLine();
        InputValidation.validateIsBlank(input);
        int purchaseInput = Integer.parseInt(input);
        InputValidation.validateInputPurchaseAmount(purchaseInput);
        InputValidation.validateInputString(input);
        return LottoService.amountPurchaseDivide(purchaseInput);
    }

    public static List<Integer> inputWinningNum() {
        String input = Console.readLine();
        InputValidation.validateIsBlank(input);
        List<Integer> winNumberList = InputValidation.validateInputWinningNumber(input);
        InputValidation.validateNoDuplicates(winNumberList);
        InputValidation.validateNumberRange(winNumberList);
        InputValidation.validateSixNumbers(winNumberList);
        return winNumberList;
    }
}
