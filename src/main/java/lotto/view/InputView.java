package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public static int lottoBoughtPrice;
    public static String userNum, userBonusStr;

    public static void inputLottoBought() {
        lottoBoughtPrice = Integer.parseInt(Console.readLine());
    }

    public static void inputUserNum() {
        userNum = Console.readLine();
    }

    public static void inputUserBonusStr() {
        userBonusStr = Console.readLine();
    }
}
