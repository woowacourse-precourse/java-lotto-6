package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Validator;

import java.util.Arrays;
import java.util.List;

public class InputView {
    public static final String SPLIT_DELIMETER = ",";

    public static int inputCash() {
        int input = Integer.parseInt(Console.readLine());
        Validator.validateCash(input);
        return input;
    }

    public static Lotto inputLotto() {
        String input = Console.readLine();
        String[] splitedInput = input.split(SPLIT_DELIMETER);
        Lotto lotto = new Lotto(Arrays.stream(splitedInput).map(Integer::valueOf).toList());
        return lotto;
    }

    public static Bonus inputBonus() {
        String input = Console.readLine();
        Bonus bonus = new Bonus(Integer.parseInt(input));

        return bonus;
    }
}
