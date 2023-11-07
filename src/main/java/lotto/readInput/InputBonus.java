package lotto.readInput;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.validation.ErrorValidation;

public class InputBonus {
	public static int bonusNumber(List<Integer> winningNumbers) {
    	System.out.println("\n보너스 번호를 입력해 주세요.");
    	String input = Console.readLine();
        try {
            ErrorValidation.validateBonusNumber(input, winningNumbers);
            return Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return bonusNumber(winningNumbers);
        }
    }
}
