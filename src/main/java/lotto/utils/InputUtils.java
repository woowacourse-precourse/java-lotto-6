package lotto.utils;

import camp.nextstep.edu.missionutils.Console;
import lotto.code.ErrorMessage;
import lotto.code.GameMessage;
import lotto.dto.WinningLottoNumberDto;

import java.util.Arrays;
import java.util.List;

public class InputUtils {

    private InputUtils() {
        throw new IllegalStateException("Utility class");
    }

    public static int getAmount() {
        String input = null;

        while (true) {
            PrintUtils.print(GameMessage.INPUT_AMOUNT);
            input = Console.readLine();
            boolean isValid = false;
            try {
                isValid = ValidationUtils.validateAmount(input);
            } catch (IllegalArgumentException e) {
                PrintUtils.print(e.getMessage());
            }

            if (isValid) {
                break;
            }

        }

        return Integer.parseInt(input);
    }

    public static WinningLottoNumberDto getWinningLottoNumber() {
        List<Integer> winnerNumbers = InputUtils.getWinnerNumbers();
        int bonusNumber = InputUtils.getBonusNumber();
        return new WinningLottoNumberDto(winnerNumbers, bonusNumber);
    }

    public static List<Integer> getWinnerNumbers() {
        String input = null;

        while (true) {
            PrintUtils.print("");
            PrintUtils.print(GameMessage.INPUT_WINNER_NUMBERS);
            input = Console.readLine();
            boolean isValid = false;
            try {
                isValid = ValidationUtils.validate(convertToWinnerNumbers(input));
            } catch (IllegalArgumentException e) {
                PrintUtils.print(e.getMessage());
            }

            if (isValid) {
                break;
            }
        }

        return convertToWinnerNumbers(input);
    }

    public static List<Integer> convertToWinnerNumbers(String input) {
        ValidationUtils.validateEmpty(input);

        List<Integer> winnerNumbers = null;
        try {
            winnerNumbers = Arrays.stream(input.split(",")).map(Integer::valueOf).toList();
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBERS.getMessage());
        }

        return winnerNumbers;
    }

    public static Integer getBonusNumber() {
        String input = null;

        while (true) {
            PrintUtils.print("");
            PrintUtils.print(GameMessage.INPUT_BONUS_NUMBER);
            input = Console.readLine();
            boolean isValid = false;
            try {
                isValid = ValidationUtils.validateBonusNumber(input);
            } catch (IllegalArgumentException e) {
                PrintUtils.print(e.getMessage());
            }

            if (isValid) {
                break;
            }
        }

        return Integer.valueOf(input);
    }


}
