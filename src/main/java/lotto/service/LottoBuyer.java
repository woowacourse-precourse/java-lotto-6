package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.purchase.PurchaseAmount;
import lotto.domain.purchase.PurchaseLottos;
import lotto.domain.purchase.PurchasePrice;

public class LottoBuyer {

    public PurchaseAmount getPurchaseAmount(final PurchasePrice purchasePrice) {
        return new PurchaseAmount(purchasePrice.getPrice());
    }

    public PurchaseLottos purchaseLottos(final PurchaseAmount purchaseAmount) {
        final List<Lotto> lottos = IntStream.range(0, purchaseAmount.getAmount())
                .mapToObj(index -> purchaseOneLotto())
                .toList();

        return new PurchaseLottos(lottos);
    }

    private Lotto purchaseOneLotto() {
        final List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.getLottoLowerBound(),
                Lotto.getLottoUpperBound(),
                Lotto.getLottoNumberCount());

        return new Lotto(numbers);
    }

}
