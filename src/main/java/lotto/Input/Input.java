package lotto.Input;

import camp.nextstep.edu.missionutils.Console;
import lotto.Print.Print;
import lotto.Validator.Validator;

public class Input {

    //입력받은 구입 금액으로 로또 개수 구하기
    public static int getLottoBuyCount() {
        try{
            Print.printBuyLotto();
            String inputValue = Console.readLine();
            int buyPrice = Validator.checkLottoBuyPrice(inputValue);
            return buyPrice / 1000;
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getLottoBuyCount();
        }
    }

}
