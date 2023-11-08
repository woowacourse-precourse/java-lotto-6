package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private static final String INPUT_MONEY = "구입 금액을 입력해 주세요.";
    private static final String INPUT_WIN_LOTTO_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String getUserMoney(){
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public String getWinningNumber(){
        System.out.println(INPUT_WIN_LOTTO_NUMBER);
        return Console.readLine();
    }

    public String getBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
