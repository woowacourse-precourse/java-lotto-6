package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String Input_Buy_Price = "구입금액을 입력해 주세요.";

    public static String Input_Buy_Price(){
        System.out.println(Input_Buy_Price);
        return Console.readLine();
    }


}
