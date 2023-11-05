package lotto;

import camp.nextstep.edu.missionutils.Console;

public class UserInput {
    private final static String AMOUNT = "구입금액을 입력해 주세요.";
    public int purchase(){
        System.out.println(AMOUNT);
        String priceStr = Console.readLine();
        int amount = Integer.parseInt(priceStr);
        return amount;
    }
}
