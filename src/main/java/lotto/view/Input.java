package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class Input {

    private final String MESSAGE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private final String MESSAGE_ONLY_NUMBER = "숫자만 입력 가능합니다.";

    public boolean getPurchaseAmount(){
        try{
            int answer = Integer.parseInt(Console.readLine());
            Money money = new Money(answer);

            return true;
        } catch (IllegalArgumentException e){
            System.out.println(MESSAGE_ONLY_NUMBER);
            return false;
        }



    }


}
