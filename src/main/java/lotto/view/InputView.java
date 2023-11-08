package lotto.view;

import java.util.Scanner;

import static lotto.util.Instruction.*;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public static String inputWinningNumbers() {
        System.out.println(INPUT_LOTTO_WINNING_NUMBERS_MESSAGE.getMessage());
        return scanner.nextLine();
    }

    public static String inputBonusNumber() {
        System.out.println();
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_MESSAGE.getMessage());
        return scanner.nextLine();
    }
}
