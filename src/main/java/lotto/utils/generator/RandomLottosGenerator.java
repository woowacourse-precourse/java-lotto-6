package lotto.utils.generator;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.constants.Values;
import lotto.domain.Lotto;

public class RandomLottosGenerator implements LottsGenerator {

    private final int purchaseAmount;

    public RandomLottosGenerator(int purchaseAmount) {
        this.purchaseAmount = purchaseAmount;
    }

    @Override
    public List<Lotto> generateLottos() {
        int purchasedLottoCount = purchaseAmount / Values.LOTTO_PURCHASE_UNIT;
        return IntStream.range(0, purchasedLottoCount)
                .mapToObj(i -> new Lotto(generateNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> generateNumbers() {
        return Randoms.pickUniqueNumbersInRange(Values.LOTTO_MIN_NUMBER,
                Values.LOTTO_MAX_NUMBER, Values.LOTTO_NUMBER_COUNT);
    }
}
