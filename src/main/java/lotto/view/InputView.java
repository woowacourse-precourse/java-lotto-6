package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.WinningNumValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String inputMoney() {
        return Console.readLine();
    }

    public static List<Integer> inputWinningNum() {
        String input = Console.readLine();
        try {
            WinningNumValidator winningNumValidator = new WinningNumValidator(input);
            return parseStringToInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputWinningNum();
        }
    }

    public static String inputBonusNum() {
        return Console.readLine();
    }

    public static List<Integer> parseStringToInt(String input) {
        List<Integer> winningNumber = new ArrayList<>();
        for (String number : input.split(",")) {
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

}
