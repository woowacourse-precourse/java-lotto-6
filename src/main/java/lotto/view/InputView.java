package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.List;

import static lotto.common.InfoMessage.*;
import static lotto.common.validator.*;

public class InputView {

    public int inputPurchaseAmount() {
        System.out.println(PURCHASE_PRICE_INPUT.getMessage());
        String userPurchaseAmout = Console.readLine();
        return isValidPurchaseAmout(userPurchaseAmout);
    }

    public Lotto inputWinningNumber() {
        System.out.println();
        System.out.println(WINNING_NUMBERS_INPUT.getMessage());
        String winningNumInput = Console.readLine();
        List<Integer> validWinningNumber = isValidWinningNumber(winningNumInput);
        return new Lotto(validWinningNumber);
    }

    public int inputBonusNumber() {
        System.out.println();
        System.out.println(BONUS_NUMBER_INPUT.getMessage());
        String bonusNumberInput= Console.readLine();
        return isValidBonusNumber(bonusNumberInput);
    }



}
