package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private static final int LOTTO_MIN_NUMBER = 1;
    private static final int LOTTO_MAX_NUMBER = 45;
    private static final int LOTTO_COUNT = 6;
    private static final int LOTTO_PRICE = 1_000;

    private final List<Lotto> lottos;

    public LottoMachine(int purchaseAmount) {
        int purchaseCount = parseMoneyToCount(purchaseAmount);
        this.lottos = issuedLottos(purchaseCount);
    }

    private int parseMoneyToCount(int purchaseAmount) {
        return purchaseAmount / LOTTO_PRICE;
    }

    private List<Lotto> issuedLottos(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(count -> new Lotto(createNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER, LOTTO_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
