package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import static lotto.util.GameMessage.*;

public class InputView {

    public static int getAmount() {
        System.out.println(INPUT_AMOUNT_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }

    public static String getLuckyNumber() {
        System.out.println(INPUT_LUCKY_NUMBER_MESSAGE.getMessage());

        return Console.readLine();
    }

    public static int getBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE.getMessage());

        return Integer.parseInt(Console.readLine());
    }
}
