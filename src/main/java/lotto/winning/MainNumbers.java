package lotto.winning;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.function.Predicate;
import lotto.Askable;
import lotto.Settings;

public class MainNumbers extends WinningNumbers implements Askable<List<Integer>> {
    @Override
    public List<Integer> ask() {
        System.out.println(INPUT_WINNING_NUMBERS);

        String input;
        List<Integer> convertedInput;
        do {
            input = readLine();
            convertedInput = super.convertInput(input);

        } while (validate(convertedInput));

        System.out.println();

        return convertedInput;
    }

    private boolean validate(List<Integer> convertedInput) {
        boolean isIncorret = false;

        try {
            checkValidity(convertedInput);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isIncorret = true;
        }

        return isIncorret;
    }

    protected void checkValidity(List<Integer> convertedInput) {
        if (!isCorrectRange.test(convertedInput)) {
            throw new IllegalArgumentException(NUMBER_RANGE_ERROR);
        }
        if (!isNoDuplicate.test(convertedInput)) {
            throw new IllegalArgumentException(DUPLICATE_NUMBERS_ERROR);
        }
        if (!isCorrectAmount.test(convertedInput)) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROR);
        }
    }

    private final Predicate<List<Integer>> isNoDuplicate = input ->
            input.stream().distinct().count() == input.size();

    private final Predicate<List<Integer>> isCorrectAmount = input -> input.size() == Settings.SIZE.getNumber();
}
