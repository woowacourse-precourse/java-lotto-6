package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static validate.GeneralExceptionHandler.validateMinimumPurchaseAmount;
import static validate.GeneralExceptionHandler.validateNotDividePurchaseAmount;
import static validate.GeneralExceptionHandler.validateNumberExceptionHandler;

public class InputView {

    public static final String USER_PURCHASE_AMOUNT = "구매금액을 입력해주세요";

    public static int purchaseAmount() {
        System.out.println(USER_PURCHASE_AMOUNT);
        try {
            int userPurchaseAmount = validateNumberExceptionHandler(readLine());
            validateMinimumPurchaseAmount(userPurchaseAmount);
            validateNotDividePurchaseAmount(userPurchaseAmount);
            return userPurchaseAmount;

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return purchaseAmount();
        }
    }

}
