package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.consts.ConstsString.INPUT_PURCHASE_PRICE;
import static lotto.consts.ConstsString.INPUT_BONUS_NUMBER;
import static lotto.consts.ConstsString.INPUT_WIN_NUMBER;


public class InputView {
    public String setWinNumber(){
        System.out.println(INPUT_WIN_NUMBER);
        return Console.readLine();
    }

    public String setBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

    public String setPurchasePrice(){
        System.out.println(INPUT_PURCHASE_PRICE);
        return Console.readLine();
    }
}
