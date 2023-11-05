package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.util.ExceptionEnum;

public class InputView{

    public static Price inputPurchasePrice(){
        System.out.println("구입 금액을 입력해주세요.");
        int price = 0;
        try{
            price = Integer.parseInt(readLine());
        }catch (NumberFormatException NFE){
            throw new IllegalArgumentException(ExceptionEnum.NOT_NUMBER_FORMAT.getMessage());
        }
        return new Price(price);
    }

    public static Lotto inputWinningNumbers(){
        return null;
    }

    public static Bonus inputBonusNumber(){
        return null;
    }

}
