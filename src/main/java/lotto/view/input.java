package lotto.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class input {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";

    public static String read(){
        return readLine();
    }

    public static String purchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT);
        return read();
    }
}
