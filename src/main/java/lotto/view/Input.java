package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import lotto.constant.Constant;

public final class Input {
    public static String amount() {
        System.out.println(Constant.amount);

        return Console.readLine();
    }

    public static String winningNumbers() {
        System.out.println(Constant.winningNumber);

        return Console.readLine();
    }

    public static String bonusNumber() {
        System.out.println(Constant.bonusNumber);

        return Console.readLine();
    }
}
