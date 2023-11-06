package lotto.winning;

import static camp.nextstep.edu.missionutils.Console.readLine;

import java.util.List;
import java.util.function.Predicate;
import lotto.Askable;
import lotto.Settings;

public class BonusNumber extends Numbers implements Askable<Integer> {
    @Override
    public Integer ask() {
        System.out.println(inputBonusNumber);

        String input;
        List<Integer> convertedInput;
        do {
            input = readLine();
            convertedInput = convertInput(input);

        } while (validate(convertedInput));

        System.out.println();

        return convertedInput.get(0);
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
        if (!isCorrectAmount.test(convertedInput)) {
            throw new IllegalArgumentException(BonusNumberAmountError);
        }
    }

    private final Predicate<List<Integer>> isCorrectAmount =
            input -> input.size() == Settings.BONUS_NUMBER_SIZE.getNumber();
}
