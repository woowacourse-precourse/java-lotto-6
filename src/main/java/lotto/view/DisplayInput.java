package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class DisplayInput {

    public Integer inputLottoAmountofMoney(){
        Integer inputMoney = Integer.parseInt(Console.readLine());
        return inputMoney;
    }
}
