package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.ExceptionEnum.NOT_NUMBER_FORMAT;
import static lotto.util.InputEnum.PURCHASE_AMOUNT_INPUT;

import lotto.domain.Amount;
import lotto.domain.lotteryresult.Bonus;
import lotto.domain.lotto.Lotto;

public class InputView{

    public static Amount inputPurchaseAmount(){
        System.out.println(PURCHASE_AMOUNT_INPUT.message());
        int amount = 0;
        try{
            amount = Integer.parseInt(readLine());
        } catch (NumberFormatException NFE){
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.message());
        }
        return new Amount(amount);
    }

    public static Lotto inputWinningNumbers(){
        return null;
    }

    public static Bonus inputBonusNumber(){
        return null;
    }

}
