package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.DividePurchaseAmountException;
import lotto.util.Validator;
import net.bytebuddy.pool.TypePool;

public class InputView {
    private static final String ASK_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNER_NUMBERS = "당첨 번호를 입력해 주세요";
    private static final String ERROR_MESSAGE_ABOUT_PURCHASE_AMOUNT = "[ERROR] 구입 금액은 1,000원 단위로 입력해주세요.";
    public static int inputPurchaseAmount() {
        int money = 0;
        try {
            System.out.println(ASK_PURCHASE_AMOUNT);
            money = Integer.parseInt(Console.readLine());
            Validator.validatePurchaseAmount(money);
        } catch(IllegalArgumentException e) {
            System.out.println(ERROR_MESSAGE_ABOUT_PURCHASE_AMOUNT);
        }
        return money;

    }


}
