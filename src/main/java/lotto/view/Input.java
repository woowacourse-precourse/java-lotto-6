package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    private final String INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";

    public String inputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        String inputMoney = Console.readLine();
        return inputMoney;
    }

    public String inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumbers = Console.readLine();
        return winningNumbers;
    }

    public String inputBounusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bounusNumber = Console.readLine();
        return bounusNumber;
    }


}
