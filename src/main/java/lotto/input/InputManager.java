package lotto.input;

import camp.nextstep.edu.missionutils.Console;
import lotto.data.PurchaseAmount;

public class InputManager {
    public static PurchaseAmount inputPurchaseAmount() {
        String input;
        while (true){
            try{
                input = Console.readLine();
                InputValidator.checkPurchaseAmount(input);
                break;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
        return new PurchaseAmount(Integer.parseInt(input));
    }
}
