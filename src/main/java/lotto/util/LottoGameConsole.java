package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoGameNumber;
import lotto.game.LottoGameMessage;
import lotto.model.Lotto;

public final class LottoGameConsole {
    private static final String SPLIT_REGEX = ",";

    private LottoGameConsole() {
        // Don't let anyone instantiate this class.
    }

    public static void print(LottoGameMessage message) {
        System.out.println(message.getMessage());
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
        if (cost < LottoGameNumber.COST_UNIT || cost % LottoGameNumber.COST_UNIT != 0) {
            throw new IllegalArgumentException();
        }
    }

    private static List<Integer> convertToIntegerList(String input) {
        return Arrays.stream(input.split(SPLIT_REGEX))
                .map(Integer::parseInt)
                .toList();
    }

    private static void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < LottoGameNumber.MINIMUM || bonusNumber > LottoGameNumber.MAXIMUM) {
            throw new IllegalArgumentException();
        }
    }
}
