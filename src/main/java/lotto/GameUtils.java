package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.domain.Lotto;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.List;

public final class GameUtils {
    private GameUtils() {
    }

    public static int convertToNumber(String input) {
        return Integer.parseInt(input);
    }

    public static List<String> splitStringByDelimiter(String input, String delimiter) {
        return Arrays.asList(input.split(delimiter, -1));
    }

    public static Lotto createRandomLotto(int size) {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_RANGE_MIN, Lotto.LOTTO_RANGE_MAX, size);
        return new Lotto(numbers);
    }

    public static Lotto createManualLotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public static String convertToMoney(long prize) {
        DecimalFormat decimalFormat = new DecimalFormat("###,###");
        return decimalFormat.format(prize) + "원";
    }

    public static double convertToPercentageFirstDecimalPlace(double decimal) {
        return Math.round(decimal * 1000) / 10.0;
    }

    public static boolean isNotNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }
}
