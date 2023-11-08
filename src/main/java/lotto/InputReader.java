package lotto;

import static lotto.ErrorMessages.INVALID_BONUS_RANGE;
import static lotto.Validator.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputReader {
    private static final int START_RANGE = 1;
    private static final int END_RANGE = 45;
    public static int inputPurchaseAmount() {
        return checkIsInteger(Console.readLine());
    }

    public static Lotto inputWinningLotto() {
        String numbers = Console.readLine();
        List<Integer> winningLotto = getLottoFormat(numbers);

        return new Lotto(winningLotto);
    }

    private static List<Integer> getLottoFormat(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    public static int inputBonusNumber() {
        int bonus = Integer.parseInt(Console.readLine());
        validateBonus(bonus);

        return bonus;
    }

    private static void validateBonus(int bonus) {
        if (bonus < START_RANGE || bonus > END_RANGE) {
            throw new IllegalArgumentException(INVALID_BONUS_RANGE);
        }
    }
}
