package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {

    private static final String PRINT_COST = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public String getCost(){
        System.out.println(PRINT_COST);
        return Console.readLine();
    }

    public String getWinningNumber(){
        System.out.println(PRINT_WINNING_NUMBER);
        return Console.readLine();
    }

    public String getBonusNumber(){
        System.out.println(PRINT_BONUS_NUMBER);
        return Console.readLine();
    }
}

