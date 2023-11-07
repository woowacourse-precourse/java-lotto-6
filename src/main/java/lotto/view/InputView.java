package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.util.validator.BlankValidator;
import lotto.util.validator.IntegerValidator;
import lotto.view.dto.BonusNumberRequestDto;
import lotto.view.dto.MainNumbersRequestDto;
import lotto.view.dto.PurchaseAmountRequestDto;

public class InputView {
    public static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String INPUT_MAIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    public static final String INPUT_BONUS_NUMBERS_MESSAGE = "보너스 번호를 입력해 주세요.";

    public PurchaseAmountRequestDto readPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        String purchaseAmount = getInput();
        validatePurchaseAmount(purchaseAmount);

        return new PurchaseAmountRequestDto(purchaseAmount);
    }

    public MainNumbersRequestDto readMainNumbers() {
        System.out.println(INPUT_MAIN_NUMBERS_MESSAGE);
        String mainNumbers = getInput();
        validateMainNumbers(mainNumbers);

        return new MainNumbersRequestDto(mainNumbers);
    }

    private String getInput() {
        return Console.readLine();
    }

    private void validatePurchaseAmount(String input) {
        BlankValidator.validate(input);
        IntegerValidator.validateInteger(input);
    }

    private void validateMainNumbers(String input) {
        BlankValidator.validate(input);
    }

    public BonusNumberRequestDto readBonusNumbers() {
        System.out.println(INPUT_BONUS_NUMBERS_MESSAGE);
        String bonusNumber = getInput();
        validateBonusNumber(bonusNumber);

        return new BonusNumberRequestDto(bonusNumber);
    }

    private void validateBonusNumber(String input) {
        BlankValidator.validate(input);
        IntegerValidator.validateInteger(input);
    }
}
