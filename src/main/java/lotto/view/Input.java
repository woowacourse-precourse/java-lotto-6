package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class Input {

    private final String MESSAGE_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private final String MESSAGE_ONLY_NUMBER = "공백이 없는 숫자만 입력 가능합니다.";

    public int getPurchaseAmount(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e){
            System.out.println(MESSAGE_ONLY_NUMBER);
            return getPurchaseAmount();
        }
    }


}
