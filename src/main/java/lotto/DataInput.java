package lotto;

import camp.nextstep.edu.missionutils.Console;

public class DataInput {
    public int userInputPayment(){
        String userPayment;
        userPayment = Console.readLine();
        // Validate
        return Integer.parseInt(userPayment);
    }

    public int userInputBonusNumber(){
        String userBonusNumber;
        userBonusNumber = Console.readLine();
        // Validate
        return Integer.parseInt(userBonusNumber);
    }
}
