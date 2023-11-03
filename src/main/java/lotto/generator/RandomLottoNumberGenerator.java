package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;

public class RandomLottoNumberGenerator {

    private static final int START_LOTTO_NUMBER = 1;
    private static final int END_LOTTO_NUMBER = 45;
    private static final int GENERATE_COUNT = 6;

    private static final Supplier<List<Integer>> supplier = RandomLottoNumberGenerator::generate;

    private RandomLottoNumberGenerator() {
    }

    private static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(START_LOTTO_NUMBER, END_LOTTO_NUMBER, GENERATE_COUNT);
    }

    public static Supplier<List<Integer>> getSupplier() {
        return supplier;
    }
}
