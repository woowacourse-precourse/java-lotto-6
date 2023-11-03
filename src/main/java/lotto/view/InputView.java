package lotto.view;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String inputMoney(){
        System.out.println(InputMessage.INPUT_MONEY_MESSAGE.getMessage());
        return Console.readLine();
    }
}
