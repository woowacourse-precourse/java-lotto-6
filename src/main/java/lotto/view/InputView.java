package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringUtil;

import java.util.List;

public class InputView {

    public int insertPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");

        try {
            return StringUtil.stringToInt(Console.readLine().trim());
        } catch (IllegalArgumentException purchaseAmountError) {
            System.out.println(purchaseAmountError.getMessage());
            return insertPurchaseAmount();
        }
    }

    public List<Integer> insertWinningNumber() {
        System.out.println("\n당첨 번호를 입력해 주세요.");

        try {
            return StringUtil.StringToList(Console.readLine().trim());
        } catch (IllegalArgumentException winningNumberError) {
            System.out.println(winningNumberError.getMessage());
            return insertWinningNumber();
        }
    }

    public int insertBonusNumber() {
        System.out.println("\n보너스 번호를 입력해 주세요.");

        try {
            return StringUtil.stringToInt(Console.readLine().trim());
        } catch (IllegalArgumentException bonusNumberError) {
            System.out.println(bonusNumberError.getMessage());
            return insertBonusNumber();
        }
    }
}
