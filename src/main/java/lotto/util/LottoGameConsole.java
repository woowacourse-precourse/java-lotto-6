package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoNumber;
import lotto.model.Lotto;

public final class LottoGameConsole {
    private static final String SPLIT_REGEX = ",";
    private static final int COST_UNIT = 1_000;

    private LottoGameConsole() {
        // Don't let anyone instantiate this class.
    }

    public static int readCost() {
        String input = Console.readLine();
        int cost = Integer.parseInt(input);

        validateCost(cost);

        return cost;
    }

    public static Lotto readTargetLotto() {
        String input = Console.readLine();
        List<Integer> numbers = convertToIntegerList(input);

        return new Lotto(numbers);
    }

    public static int readBonusNumber() {
        String input = Console.readLine();
        int bonusNumber = Integer.parseInt(input);

        validateBonusNumber(bonusNumber);

        return bonusNumber;
    }

    private static void validateCost(int cost) {
        if (cost < COST_UNIT || cost % COST_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(SPLIT_REGEX))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoNumber.MINIMUM || bonusNumber > LottoNumber.MAXIMUM) {
            throw new IllegalArgumentException();
        }
    }
}
