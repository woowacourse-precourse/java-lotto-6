package lotto.readInput;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;


public class InputNumbers {
    public static List<Integer> winningNumbers() {
    	System.out.println("\n당첨 번호를 입력해 주세요.");
    	String input = Console.readLine();
        try {
            ErrorValidation.validateWinningNumbersFormat(input);
            List<Integer> winningNumbers = new ArrayList<>();
            winningNumbers = Stream.of(input.split(",")).map(Integer::parseInt).toList();
            ErrorValidation.validateWinningNumbers(winningNumbers);
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return winningNumbers();
        }
    }
}
