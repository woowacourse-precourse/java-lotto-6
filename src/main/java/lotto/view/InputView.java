package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.NumericValidator;
import lotto.view.dto.PurchaseAmountRequestDto;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";

    public PurchaseAmountRequestDto readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = getInput();
        validatePurchaseAmount(purchaseAmount);

        return new PurchaseAmountRequestDto(purchaseAmount);
    }

    private String getInput() {
        return Console.readLine();
    }

    private void validatePurchaseAmount(String input) {
        BlankValidator.validate(input);
        NumericValidator.validateInteger(input);
    }
}
