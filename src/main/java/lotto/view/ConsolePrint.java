package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Magic;

public class ConsolePrint {
    public static String readLottoNum() {
        System.out.println(Magic.INPUT_PRICE);
        return Console.readLine();
    }

    public static String readWinningNum() {
        System.out.println(Magic.INPUT_NUM);
        return Console.readLine();
    }

    public static String readBonusNum() {
        System.out.println(Magic.INPUT_BONUS_NUM);
        return Console.readLine();
    }
}
