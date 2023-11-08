package lotto.Util;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;

public class RandomNumber {
    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 45;
    private static final int NumberQuantity = 6;

    public static List<Integer> generateRandomNumberList(List<Integer> randomNumberList) {
        IntStream.generate(() -> Randoms.pickNumberInRange(MIN_NUMBER, MAX_NUMBER))
                .distinct()
                .limit(NumberQuantity)
                .forEach(randomNumberList::add);

        return randomNumberList;
    }
}
