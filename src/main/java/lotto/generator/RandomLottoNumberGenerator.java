package lotto.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.lotto.LottoCondition;

public class RandomLottoNumberGenerator {

    private static final Supplier<List<Integer>> supplier = RandomLottoNumberGenerator::generate;

    private RandomLottoNumberGenerator() {
    }

    private static List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(
                LottoCondition.MIN_NUMBER.value(),
                LottoCondition.MAX_NUMBER.value(),
                LottoCondition.NUMBER_LENGTH.value()
        );
    }

    public static Supplier<List<Integer>> getSupplier() {
        return supplier;
    }
}
