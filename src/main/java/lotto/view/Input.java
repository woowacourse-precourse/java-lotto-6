package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.PirzeResult;
import lotto.model.PrizeMoney;
import lotto.validate.InvalidlputException;

import java.util.List;

public class Input {
    private final String INPUT_MONEY_MESSAGE = "구매금액을 입력해주세요.";
    private final String INPUT_WINNING_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";
    private final String INPUT_BONUS_NUMBER_MESSAGE = "당첨 번호를 입력해주세요.";

    public int inputMoney(){
        System.out.println(INPUT_MONEY_MESSAGE);
        String inputMoney = Console.readLine();
        int money = Integer.parseInt(inputMoney);
        InvalidlputException.validateMoneyRange(money);
        InvalidlputException.validateMoneyDivided(money);
        return money;
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println();
        System.out.println(INPUT_WINNING_NUMBER_MESSAGE);
        String winningNumbers = Console.readLine();
        PirzeResult pirzeResult = new PirzeResult();
        return pirzeResult.splitNumber(winningNumbers);
    }

    public String inputBounusNumber() {
        System.out.println();
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        String bounusNumber = Console.readLine();
        return bounusNumber;
    }


}
