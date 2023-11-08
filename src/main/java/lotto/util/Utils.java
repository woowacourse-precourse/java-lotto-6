package lotto.util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lotto.validation.Validation;

public class Utils {
    private static final int NUMBER_START_INCLUSIVE = 1;
    private static final int NUMBER_END_INCLUSIVE = 45;
    private static final int NUMBER_PICK_COUNT = 6;
    private static final String SPLIT_DELIMETER = ",";

    public static int stringToInt(String string) {
        Validation.validateStringToInteger(string);
        return Integer.parseInt(string.trim());
    }

    public static List<Integer> stringToIntegerList(String string) {
        String[] stringArray = string.trim().split(SPLIT_DELIMETER);
        Validation.validateStringArrayToIntegerList(stringArray);
        return Arrays.stream(stringArray).map(Integer::parseInt).collect(Collectors.toList());
    }

    public static List<Integer> createSortedLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(NUMBER_START_INCLUSIVE, NUMBER_END_INCLUSIVE,
                                                                      NUMBER_PICK_COUNT);
        lottoNumbers.sort(Comparator.naturalOrder());
        return lottoNumbers;
    }
}
