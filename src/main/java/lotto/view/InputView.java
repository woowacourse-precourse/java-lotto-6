package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.utils.Templates;

public class InputView {
    public String getUserBuyAmount() {
        print(Templates.BUY_MESSAGE);
        String amount = Console.readLine();

        return amount;
    }

    public String getPrizingNumbers() {
        print(Templates.GET_PRIZING_NUMBERS_MESSAGE);
        String numbers = Console.readLine();

        return numbers;
    }

    public String getBonusNumbers() {
        print(Templates.GET_BONUS_NUMBER_MESSAGE);
        String bonus = Console.readLine();

        return bonus;
    }


    private void print(Templates string) {
        System.out.println(string);
    }

}
