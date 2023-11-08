package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.util.constant.LottoConstant;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class LottoMachine {
    private final List<Lotto> lottos;

    public LottoMachine(int purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        int purchaseCount = parseMoneyToCount(purchaseAmount);
        this.lottos = issuedLottos(purchaseCount);
    }

    private int parseMoneyToCount(int purchaseAmount) {
        return purchaseAmount / LottoConstant.LOTTO_PRICE;
    }

    private List<Lotto> issuedLottos(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(count -> new Lotto(createNumbers()))
                .collect(Collectors.toList());
    }

    private List<Integer> createNumbers() {
        return Randoms.pickUniqueNumbersInRange(LottoConstant.LOTTO_MIN_NUMBER, LottoConstant.LOTTO_MAX_NUMBER,
                        LottoConstant.LOTTO_COUNT)
                .stream()
                .sorted()
                .collect(Collectors.toList());
    }

    private void validatePurchaseAmount(int purchaseAmount) {
        if (purchaseAmount % LottoConstant.LOTTO_PRICE > 0) {
            throw new IllegalArgumentException();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }
}
