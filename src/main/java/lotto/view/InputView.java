package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Price;

public class InputView{

    public Price inputPurchasePrice(){
        System.out.println("구입 금액을 입력해주세요.");
        int price = 0;
        try{
            price = Integer.parseInt(readLine());
        }catch (NumberFormatException NFE){
            throw new IllegalArgumentException();
        }
        return new Price(price);
    }

    public Lotto inputWinningNumbers(){
        return null;
    }

    public Bonus inputBonusNumber(){
        return null;
    }

}
