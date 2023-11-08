package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBERS = "\n당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";


    public String inputBudget() {
        System.out.println(INPUT_MONEY);
        return Console.readLine();
    }

    public String inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBERS);
        return Console.readLine();
    }

    public String inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER);
        return Console.readLine();
    }

}
