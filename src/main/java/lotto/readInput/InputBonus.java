package lotto.readInput;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class InputBonus {
	
	public static int bonusNumber(List<Integer> winningNumbers) {
        try {
            String input = Console.readLine();
            ErrorValidation.validateBonusNumber(input, winningNumbers);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumber(winningNumbers);
        }
    }
}
