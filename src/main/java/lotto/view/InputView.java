package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY_TO_BUY = "구입금액을 입력해 주세요.";

    private static final String INPUT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";

    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String inputMoneyToBuyMessage(){
        System.out.println(INPUT_MONEY_TO_BUY);
        return Console.readLine();
    }
    public static String inputWinningNumberMessage(){
        System.out.println('\n'+INPUT_WINNING_NUMBER);
        return Console.readLine();
    }

    public static String inputBonusNumberMessage(){
        System.out.println('\n'+INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
