package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static lotto.util.ExceptionEnum.NOT_NUMBER_FORMAT;

import lotto.domain.Amount;
import lotto.domain.lotteryresult.Bonus;
import lotto.domain.lotto.Lotto;

public class InputView{

    public static Amount inputPurchasePrice(){
        System.out.println("구입 금액을 입력해주세요.");
        int amount = 0;
        try{
            amount = Integer.parseInt(readLine());
        } catch (NumberFormatException NFE){
            throw new IllegalArgumentException(NOT_NUMBER_FORMAT.getMessage());
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
