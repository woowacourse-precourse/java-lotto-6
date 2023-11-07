package lotto.view;

import static lotto.Constant.*;
import camp.nextstep.edu.missionutils.Console;
public class View {

    public String inputBuyingMoney(){
        System.out.println(INPUT_BUYING_NUM_MESSEAGE);
        return Console.readLine();
    }
    public void exceptionMessage(){
        System.out.println(INPUT_BUYING_NUM_EXCEPTION_MESSAGE);
    }
}
