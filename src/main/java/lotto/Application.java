package lotto;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    private static final String MESSAGE_FOR_PURCHASE_AMOUNT_INPUT = "구입금액을 입력해 주세요.";
    public static void main(String[] args) {
        int purchaseAmount = getPurchaseAmountWithInput();
    }

    private static int getPurchaseAmountWithInput() {
        System.out.println(MESSAGE_FOR_PURCHASE_AMOUNT_INPUT);
        //while (true) {
            String purchaseAmountInput = Console.readLine();
        //}
        return 0;
    }

}
