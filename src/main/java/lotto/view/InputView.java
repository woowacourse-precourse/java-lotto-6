package lotto.view;

import static lotto.view.constant.Constant.INPUT_AMOUNT_MESSAGE;
import static lotto.view.constant.Constant.INPUT_BONUS_NUMBER_MESSAGE;
import static lotto.view.constant.Constant.INPUT_LOTTO_NUMBER_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.constant.Constant;

public class InputView {
    public static int inputAmount() {
        print(INPUT_AMOUNT_MESSAGE);

        return Integer.parseInt(Console.readLine());
    }

    public static int inputBonusNumber() {
        print(INPUT_BONUS_NUMBER_MESSAGE);
        printNewLine();
        return Integer.parseInt(Console.readLine());
    }

    public static String inputWinningLottoNumber() {
        print(INPUT_LOTTO_NUMBER_MESSAGE);
        printNewLine();
        return Console.readLine();
    }

    private static void print(Constant message) {
        System.out.print(message);
        printNewLine();
        Console.readLine();
    }

    private static void printNewLine() {
        System.out.print("\n");
    }
}
