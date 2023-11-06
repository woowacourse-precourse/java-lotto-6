package lotto.view;

import java.util.Scanner;
import static lotto.util.Instruction.PRINT_INPUT_MONEY;

public class InputView {

    private static final Scanner scanner = new Scanner(System.in);
    private InputView() {
    }

    public static String inputMoney() {
        System.out.println(PRINT_INPUT_MONEY.getMessage());
        return scanner.nextLine();
    }
}
