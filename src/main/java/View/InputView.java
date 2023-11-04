package View;
import camp.nextstep.edu.missionutils.Console;

import static lotto.Constants.*;

public class InputView {
    public static String purchaseAmountInput() {
        System.out.println(PURCHASE_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String winningNumbersInput() {
        System.out.println(WINNING_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String bounsNumberInput(){
        System.out.println(BOUNS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
