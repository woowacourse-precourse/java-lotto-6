package lotto.domain;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Validators;

public class Manager {
    public static int receiveMoney(){
        String inputMoney = Console.readLine();
        while(!Validators.validate(inputMoney)) {inputMoney = Console.readLine();}
        return Integer.parseInt(inputMoney);
    }
}
