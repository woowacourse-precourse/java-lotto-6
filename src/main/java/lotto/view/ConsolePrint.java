package lotto.view;

import static lotto.constant.Magic.INPUT_NUMBERS;
import static lotto.constant.Magic.INPUT_PRICE;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Magic;

public class ConsolePrint {
    public static String readPrice() {
        System.out.println(INPUT_PRICE);
        return Console.readLine();
    }

    public static String readWinningNum() {
        System.out.println(INPUT_NUMBERS);
        return Console.readLine();
    }

    public static String readBonusNum() {
        System.out.println(Magic.INPUT_BONUS_NUMBER);
        return Console.readLine();
    }


}
