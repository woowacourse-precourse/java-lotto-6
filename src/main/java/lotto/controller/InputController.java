package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.InputMessage;

public class InputController {

    public static int inputPrice() throws NumberFormatException{
        System.out.println(InputMessage.INPUT_PRICE_MESSAGE);

        return Integer.parseInt(Console.readLine());
    }

    public static List<Integer> inputWinningNumber() throws NumberFormatException{
        System.out.println();
        System.out.println(InputMessage.INPUT_WINNING_NUMBER_MESSAGE);
        List<Integer> winningNumbers = splitToParameter(Console.readLine());

        return winningNumbers;
    }

    public static int inputBonusNumber() throws NumberFormatException{
        int bonusNumber = 0;

        System.out.println();
        System.out.println(InputMessage.INPUT_BONUS_NUMBER_MESSAGE);
        bonusNumber = Integer.parseInt(Console.readLine());

        return bonusNumber;
    }

    private static List<Integer> splitToParameter(String input) throws NumberFormatException{
        return Arrays.stream(input.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
