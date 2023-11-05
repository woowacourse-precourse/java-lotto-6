package lotto.view;
import static java.lang.Integer.parseInt;
import static lotto.view.OutputView.ASK_INPUT_MONEY;

import camp.nextstep.edu.missionutils.Console;

public class Request {
    public static String requestNubmer(){
        System.out.println(ASK_INPUT_MONEY);
        return Console.readLine();
    }
}
