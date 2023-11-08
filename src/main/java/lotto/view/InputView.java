package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    //굳이 final과 static을 같이 써야 하나?
    private final static String INPUT_PRICE_MENT = "구입금액을 입력해 주세요.";
    private final static String INPUT_WINNING_NUMBERS_MENT = "\n당첨 번호를 입력해 주세요.";
    private final static String INPUT_BONUS_NUMBER_MENT= "\n보너스 번호를 입력해 주세요.";

    public String getMoney() {
        System.out.println(INPUT_PRICE_MENT);
        return Console.readLine();
    }

    public String getWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS_MENT);
        return Console.readLine();
    }

    public String getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MENT);
        return Console.readLine();
    }


}
