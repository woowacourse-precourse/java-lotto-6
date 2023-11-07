package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorMessage;
import lotto.util.InputMessage;
import lotto.util.LottoValues;

public class InputController {

    public static int inputPrice() throws IllegalArgumentException{
        int customerPrice;

        System.out.println(InputMessage.INPUT_PRICE_MESSAGE);
        try {
            customerPrice = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        return customerPrice;
    }

    public static List<Integer> inputWinningNumber() throws NumberFormatException{
        List<Integer> winningNumber;

        System.out.println();
        System.out.println(InputMessage.INPUT_WINNING_NUMBER_MESSAGE);

        try {
            winningNumber = splitToParameter(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.ERROR_INPUT_NOT_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
        return winningNumber;
    }

    public static int inputBonusNumber() throws NumberFormatException{
        Integer bonusNumber;

        try {
            bonusNumber = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            System.out.println(ErrorMessage.ERROR_INPUT_NOT_NUMBER_MESSAGE);
            throw new IllegalArgumentException();
        }
        return bonusNumber;
    }

    private static List<Integer> splitToParameter(String input) throws NumberFormatException{
        return Arrays.stream(input.split(LottoValues.INPUT_SPLIT_PARAMETER))
                .map(String::trim)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
