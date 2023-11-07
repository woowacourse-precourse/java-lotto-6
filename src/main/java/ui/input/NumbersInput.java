package ui.input;

import camp.nextstep.edu.missionutils.Console;
import domain.ErrorMessage;
import domain.WinningNumbers;
import lotto.Lotto;
import parser.IntegerParser;

import java.util.List;

public class NumbersInput {
    public static WinningNumbers getWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winningNumberInput = Console.readLine();
        System.out.println();
        List<Integer> winningNumbers = IntegerParser.parseNumbers(winningNumberInput);
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumberInput = Console.readLine();
        System.out.println();
        int bonusNumber = Integer.parseInt(bonusNumberInput);

        validateNumbers(winningNumbers);
        validateNumber(bonusNumber);

        return new WinningNumbers(new Lotto(winningNumbers), bonusNumber);
    }

    private static void validateNumbers(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toString());
        }
    }

    private static void validateNumber(int number) {
        if (number < 1 || number > 45) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_RANGE.toString());
        }
    }
}
