package lotto.winning;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.function.Predicate;
import lotto.Askable;
import lotto.Settings;

public class WinningNumbers extends Numbers implements Askable<List<Integer>> {
    @Override
    public List<Integer> ask() {
        System.out.println(inputWinningNumbers);

        String input;
        List<Integer> convertedInput;
        do {
            input = readLine();
            convertedInput = convertInput(input);

        } while (validate(convertedInput));

        System.out.println();

        return convertedInput;
    }

    @Override
    protected boolean validate(List<Integer> convertedInput) {
        boolean isIncorret = false;

        try {
            checkValidity(convertedInput);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            isIncorret = true;
        }

        return isIncorret;
    }

    private void checkValidity(List<Integer> convertedInput) {
        if (!isCorrectRange.test(convertedInput)) {
            throw new IllegalArgumentException(numberRangeError);
        }
        if (!isNoDuplicate.test(convertedInput)) {
            throw new IllegalArgumentException(duplicateNumbersError);
        }
        if (!isCorrectAmount.test(convertedInput)) {
            throw new IllegalArgumentException(WinningNumberAmountError);
        }
    }

    private final Predicate<List<Integer>> isNoDuplicate = input ->
            input.stream().distinct().count() == input.size();

    private final Predicate<List<Integer>> isCorrectAmount = input -> input.size() == Settings.SIZE.getNumber();
}
