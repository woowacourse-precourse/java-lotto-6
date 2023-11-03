package view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static generalexceptionhandler.GeneralExceptionHandler.numberExceptionHandler;

public class Display {

    private static final String STRING_PURCHASE_AMOUNT_INPUT = "구매금액을 입력해주세요";
    private String lottoPurchaseAmount;

    public Display() {
        setLottoPurchaseAmount();
    }

    private void setLottoPurchaseAmount() {
//        System.out.println("구매금액을 입력해주세요.");
        System.out.println(STRING_PURCHASE_AMOUNT_INPUT);
//        this.lottoPurchaseAmount = readLine();
        int userPurchaseAmount = numberExceptionHandler(readLine());
//        checkMinimumPurchaseAmount(userPurchaseAmount);
    }

//    private void checkMinimumPurchaseAmount(int userPurchaseAmount) {
//
//    }
}
