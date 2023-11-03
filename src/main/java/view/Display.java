package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static generalexceptionhandler.GeneralExceptionHandler.numberExceptionHandler;

public class Display {

    private static final String STRING_PURCHASE_AMOUNT_INPUT = "구매금액을 입력해주세요";
    public static final String PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE = "=[EEOR] 구매 금액이 1000원 미만입니다.";
    private int lottoPurchaseAmount;

    public Display() {
        setLottoPurchaseAmount();
    }

    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    public Display(int lottoPurchaseAmount) {
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    private void setLottoPurchaseAmount() {
        System.out.println(STRING_PURCHASE_AMOUNT_INPUT);
        int userPurchaseAmount = numberExceptionHandler(readLine());
        checkMinimumPurchaseAmount(userPurchaseAmount);
        this.lottoPurchaseAmount = userPurchaseAmount;
    }

    public void checkMinimumPurchaseAmount(int userPurchaseAmount) {
        if (userPurchaseAmount < 1000) {
            throw new IllegalArgumentException(PURCHASE_AMOUNT_UNDER_ERROR_MESSAGE);
        }
    }
}
