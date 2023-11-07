package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.InputViewMessage;
import lotto.validator.BonusNumberValidator;
import lotto.validator.PurchaseAmountValidator;
import lotto.validator.WinningNumberValidator;

public class InputView {
    private static InputView instance;

    private InputView() {
    }

    public static InputView getInstance() {
        if (instance == null) {
            instance = new InputView();
        }
        return instance;
    }

    public Integer readPurchaseAmount() throws IllegalArgumentException{
        System.out.println(InputViewMessage.LOTTO_PURCHASE_MESSAGE.getMessage());
        String purchaseAmount = Console.readLine();
        checkPurchaseValidate(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    private void checkPurchaseValidate(String purchaseAmount) throws IllegalArgumentException {
        new PurchaseAmountValidator().validate(purchaseAmount);
    }

    public String readWinningLotto() throws IllegalArgumentException {
        System.out.println(InputViewMessage.WINNING_LOTTO_MESSAGE.getMessage());
        String winningLotto = Console.readLine();
        new WinningNumberValidator().validate(winningLotto);
        return winningLotto;
    }

    public String readBonusNumber() throws IllegalArgumentException {
        System.out.println(InputViewMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String bonusNumber = Console.readLine();
        new BonusNumberValidator().validate(bonusNumber);
        return bonusNumber;
    }

}
