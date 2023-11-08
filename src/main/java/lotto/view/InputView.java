package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String PRICE_FROM_USER_INPUT = "구입금액을 입력해 주세요.";
    private static final String WIN_NUMBER_FROM_USER_INPUT = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBER_FROM_USER_INPUT = "보너스 번호를 입력해 주세요.";

    public static String getPriceFromUserInput(){
        System.out.println(PRICE_FROM_USER_INPUT);
        return Console.readLine();
    }
    public static String getWinNumberFromUserInput(){
        System.out.println(WIN_NUMBER_FROM_USER_INPUT);
        return Console.readLine();
    }
    public static String getBonusNumberFromUserInput(){
        System.out.println(BONUS_NUMBER_FROM_USER_INPUT);
        return Console.readLine();
    }

}
