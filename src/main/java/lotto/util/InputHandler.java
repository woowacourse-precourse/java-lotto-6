package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.domain.HitNumbers;

public class InputHandler {
    private static final InputValidator validator = new InputValidator();

    public int inputMoney() {
        String input = Console.readLine();
        return validator.validateMoney(input);
    }

    public List<Integer> inputHitNumbers() {
        String input = Console.readLine();
        return validator.validateAnswerNumbers(input);
    }

    public int inputBonusNumber(HitNumbers hitNumbers) {
        String input = Console.readLine();
        validator.validateBonusNumber(input, hitNumbers);
        return Integer.parseInt(input);
    }
}
