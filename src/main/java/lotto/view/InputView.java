package lotto.view;

import java.util.Scanner;

import static lotto.util.Instruction.INPUT_MONEY_MESSAGE;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(INPUT_MONEY_MESSAGE.getMessage());
        return scanner.nextLine();
    }
}
