package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.StringUtil;

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
}
