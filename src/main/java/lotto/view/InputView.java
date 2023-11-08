package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_BUY_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WIN_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static String getBuyAmount(){
        System.out.println(INPUT_BUY_AMOUNT_MESSAGE);
        return Console.readLine();
    }

    public static String getWinNumbers(){
        System.out.println("\n"+INPUT_WIN_NUMBERS_MESSAGE);
        return Console.readLine();
    }

    public static String getBonusNumber(){
        System.out.println("\n"+INPUT_BONUS_NUMBER_MESSAGE);
        return Console.readLine();
    }
}
