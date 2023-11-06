package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

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

    public int inputBonusNumber(List<String> answer) {
        String input = Console.readLine();
        boolean duplicatedFlag = isAnswerHasThatNumber(answer, input);
        return validator.validateBonusNumber(input, duplicatedFlag);
    }

    private boolean isAnswerHasThatNumber(List<String> answer, String bonusNumber) {
        return answer.contains(bonusNumber);
    }
}
