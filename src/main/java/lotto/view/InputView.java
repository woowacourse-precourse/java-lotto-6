package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

//    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
//    private static final String INPUT_RESULT_NUMBER = "당첨 번호를 입력해 주세요. (쉼표로 구분하여 입력)";
//    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    private static final String INPUT_MONEY = "input money";
    private static final String INPUT_RESULT_NUMBER = "input result number";
    private static final String INPUT_BONUS_NUMBER = "input bonus number";
    public static String inputMoney() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public static String[] inputWinningNumber() {
        System.out.println(INPUT_RESULT_NUMBER);
        return Console.readLine().split(",");
    }

    public static String inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
