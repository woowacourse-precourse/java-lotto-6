package lotto.view;

import static lotto.constant.Magic.EXECUTE_RESULT;
import static lotto.constant.Magic.INPUT_NUMBERS;
import static lotto.constant.Magic.INPUT_PRICE;
import static lotto.constant.Magic.PRINT_BUYNUMBER;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.Magic;
import lotto.model.Lotto;

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

    public static void printPurchased(int num) {
        System.out.println(num + PRINT_BUYNUMBER);
    }

    public static void printLotto(Lotto lotto) {
        System.out.println(lotto.getNumbers());
    }

    public static void printStatics() {
        System.out.print(EXECUTE_RESULT);
    }
}
