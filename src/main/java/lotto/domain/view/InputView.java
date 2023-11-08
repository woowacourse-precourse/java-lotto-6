package lotto.domain.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.exception.ExceptionMessage;

public class InputView {

    public int enterPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return convertToInt(input);
    }

    int convertToInt(String input){
        try{
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            ExceptionMessage.INPUT_NOT_NUMBER.throwException();
        }
        return 0;
    }

}
