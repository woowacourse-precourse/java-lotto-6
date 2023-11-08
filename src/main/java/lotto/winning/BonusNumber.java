package lotto.winning;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.function.Predicate;
import lotto.Askable;
import lotto.Settings;

public class BonusNumber extends WinningNumber implements Askable<Integer> {
    @Override
    public Integer ask() {
        System.out.println(INPUT_BONUS_NUMBER);

        String input;
        List<Integer> convertedInput;
        do {
            input = readLine();
            convertedInput = super.convertInput(input);

        } while (super.validate(convertedInput));

        System.out.println();

        return convertedInput.get(0);
    }

    @Override
    protected void checkValidity(List<Integer> convertedInput) {
        if (!isCorrectRange.test(convertedInput)) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
        if (!isCorrectAmount.test(convertedInput)) {
            throw new IllegalArgumentException(BONUS_NUMBER_SIZE_ERROR);
        }
    }

    private final Predicate<List<Integer>> isCorrectAmount =
            input -> input.size() == Settings.BONUS_NUMBER_SIZE.getNumber();
}
