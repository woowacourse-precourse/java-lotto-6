package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Constant;
import lotto.message.ExceptionMessage;

public class InputView {

    private static final InputView instance = new InputView();
    private static final String NATURAL_NUMBER_REGEX = "^[0-9]*$";

    private InputView() {

    }

    public static InputView getInstance() {
        return instance;
    }

    public String readPurchaseAmount() {
        String purchaseAmount = Console.readLine();
        try {
            validate(purchaseAmount);
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return readPurchaseAmount();
        }
        return purchaseAmount;
    }

    public String readLottryNumbers() {
        String lotteryNumber = Console.readLine();
        return lotteryNumber;
    }

    public String readBonusNumber() {
        String bonusNumber = Console.readLine();
        return bonusNumber;
    }

    private void validate(String purchaseAmount) {
        if (isNotNaturalNumber(purchaseAmount) || isNotThousandUnit(purchaseAmount)) {
            throw new IllegalArgumentException(ExceptionMessage.INVALID_PURCHASE_AMOUNT.getMessage());
        }
    }

    private boolean isNotNaturalNumber(String purchaseAmount) {
        return !purchaseAmount.matches(NATURAL_NUMBER_REGEX);
    }

    private boolean isNotThousandUnit(String purchaseAmount) {
        return Integer.parseInt(purchaseAmount) % Constant.LOTTO_TICKET_PRICE != 0;
    }
}
