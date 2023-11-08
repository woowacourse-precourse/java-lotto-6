package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ComputeLottoGenerator {

    private final Quantity quantity;

    public ComputeLottoGenerator(Quantity quantity) {
        this.quantity = quantity;
    }

    public List<Lotto> generatorLottoList() {
        int ea = quantity.getQuantity();

        return IntStream.range(0, ea)
                .mapToObj(i -> createComputeLotto())
                .collect(Collectors.toList());
    }

    private Lotto createComputeLotto() {
        return new Lotto(Randoms.pickUniqueNumbersInRange(Lotto.LOTTO_START_RANGE, Lotto.LOTTO_END_RANGE,
                Lotto.LOTTO_SIZE_NUMBER));
    }
}
