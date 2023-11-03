package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class PrintView {
    private static final String Input_Lotto_Buy = "구입금액을 입력해 주세요.";

    public static String Input_Lotto_Buy(){
        System.out.println(Input_Lotto_Buy);
        return Console.readLine();
    }
}
