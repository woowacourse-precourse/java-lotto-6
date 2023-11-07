package lotto.view;

import lotto.utility.enums.Messages;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.utility.Validation.vaildatePurchaseAmount;

public class InputView {
    private InputView(){}; //생성자로 인스턴스 생성 막기

    public static void readUserLottoPurchaseAmount() {
        boolean isValidInput = false;

        System.out.println(Messages.INPUT_LOTTO_PURCHASE_AMOUNT_MESSAGE.getMessage());
        do{
            try {
                vaildatePurchaseAmount(readLine());
                isValidInput = true;
            }catch (IllegalArgumentException | IllegalStateException e){
                ExceptionView.printExceptionMessage(e.getMessage());
            }
        }while (!isValidInput);
    }
}
