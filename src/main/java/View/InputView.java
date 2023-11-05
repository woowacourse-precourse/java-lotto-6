package View;

import camp.nextstep.edu.missionutils.Console;
import domain.Amount;
import util.ProgressMessage;

public class InputView {
    static ProgressMessage inputAmount = ProgressMessage.INPUT_AMOUNT;
    public static Amount inputLottoPurchaseAmount(){
        System.out.println(inputAmount.getProgressMessage());
        String input = Console.readLine();
        return new Amount(Integer.parseInt(input));
    }
}
