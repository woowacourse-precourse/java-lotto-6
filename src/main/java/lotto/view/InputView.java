package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.ConsoleMessage;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    private InputView(){}

    public static String inputMoney() {
        System.out.println(ConsoleMessage.INPUT_MONEY.getMessage());

        return Console.readLine();
    }

    public static List<Integer> inputNumbers() {
        System.out.println(ConsoleMessage.INPUT_LOTTO_NUMBER.getMessage());
        String inputWinningNumbers = Console.readLine();
        String[] numberStrings = inputWinningNumbers.split(",");

        List<Integer> inputNumberList = new ArrayList<>();

        for (String numStr : numberStrings) {
            int num = Integer.parseInt(numStr.trim());
            inputNumberList.add(num);
        }

        return inputNumberList;
    }

    public static int inputBonusNumber() {
        System.out.println(ConsoleMessage.INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(Console.readLine());
    }
}
