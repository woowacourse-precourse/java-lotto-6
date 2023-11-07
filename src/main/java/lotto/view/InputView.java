package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringUtil;

import java.util.List;

import static lotto.view.InputMessage.*;

public class InputView {


    public int insertPurchaseAmount() {
        System.out.println(INSERT_PURCHASE_AMOUNT.getMessage());

        try {
            return StringUtil.stringToInt(Console.readLine().trim());
        } catch (IllegalArgumentException purchaseAmountError) {
            System.out.println(purchaseAmountError.getMessage());
            return insertPurchaseAmount();
        }
    }

    public List<Integer> insertWinningNumber() {
        System.out.println();
        System.out.println(INSERT_WINNING_NUMBER.getMessage());

        try {
            return StringUtil.StringToList(Console.readLine().trim());
        } catch (IllegalArgumentException winningNumberError) {
            System.out.println(winningNumberError.getMessage());
            return insertWinningNumber();
        }
    }

    public int insertBonusNumber() {
        System.out.println();
        System.out.println(INSERT_BONUS_NUMBER.getMessage());

        try {
            return StringUtil.stringToInt(Console.readLine().trim());
        } catch (IllegalArgumentException bonusNumberError) {
            System.out.println(bonusNumberError.getMessage());
            return insertBonusNumber();
        }
    }
}
