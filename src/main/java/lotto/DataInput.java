package lotto;

import camp.nextstep.edu.missionutils.Console;

public class DataInput {
    public int userInputPurchaseAmount(){
        String userPurchaseAmount;
        userPurchaseAmount = Console.readLine();
        // Validate
        return Integer.parseInt(userPurchaseAmount);
    }

    public int userInputBonusNumber(){
        String userBonusNumber;
        userBonusNumber = Console.readLine();
        // Validate
        return Integer.parseInt(userBonusNumber);
    }
}
