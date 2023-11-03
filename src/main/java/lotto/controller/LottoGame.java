package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.Output;

public class LottoGame {
    public void gameStart(){


    }

    public int purchaseAmount(){
        System.out.println(Output.PURCHASE_AMOUNT_MESSAGE);
        int amount = amountInput();
        return amount;
    }

    public int amountInput(){
        String beforeAmount = Console.readLine();
        if(!isNumber(beforeAmount)){
            throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
        }
        int afterAmount = Integer.parseInt(beforeAmount);
        return afterAmount;
    }

    public boolean isNumber(String number){
        try {
            Integer.parseInt(number);
        } catch (NumberFormatException e){
            return false;
        }
        return true;
    }
}
