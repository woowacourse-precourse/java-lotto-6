package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String ASK_PAYMENT = "구입금액을 입력해 주세요.";
    private static final String ASK_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String ASK_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public static String getPaymentFromUserInput(){
        System.out.println(ASK_PAYMENT);
        return Console.readLine();
    }

    public static String getWinningNumbersFromUserInput(){
        System.out.println(ASK_WINNING_NUMBERS);
        return Console.readLine();
    }

    public static String getBonusNumberFromUserInput(){
        System.out.println(ASK_BONUS_NUMBER);
        return Console.readLine();
    }
}
