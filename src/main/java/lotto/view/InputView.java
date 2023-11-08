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

    public Integer readPurchaseAmount() {
        System.out.println(InputViewMessage.LOTTO_PURCHASE_MESSAGE.getMessage());
        String purchaseAmount = Console.readLine();
        new PurchaseAmountValidator().validate(purchaseAmount);
        return Integer.parseInt(purchaseAmount);
    }

    public String readWinningLotto() {
        System.out.println(InputViewMessage.WINNING_LOTTO_MESSAGE.getMessage());
        String winningLotto = Console.readLine();
        new WinningNumberValidator().validate(winningLotto);
        return winningLotto;
    }

    public String readBonusNumber() {
        System.out.println(InputViewMessage.BONUS_NUMBER_MESSAGE.getMessage());
        String bonusNumber = Console.readLine();
        new BonusNumberValidator().validate(bonusNumber);
        return bonusNumber;
    }

}
