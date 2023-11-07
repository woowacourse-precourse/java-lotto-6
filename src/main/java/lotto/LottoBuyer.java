package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.model.Lottos;
import lotto.model.PurchaseAmount;
import lotto.model.PurchasePrice;

public class LottoBuyer {

    public PurchaseAmount getPurchaseAmount(final PurchasePrice purchasePrice) {
        return new PurchaseAmount(purchasePrice.getPrice());
    }

    public Lottos purchaseLottos(final PurchaseAmount purchaseAmount) {
        List<Lotto> lottos = IntStream.range(0, purchaseAmount.getAmount())
                .mapToObj(index -> purchaseOneLotto())
                .toList();

        return new Lottos(lottos);
    }

    private Lotto purchaseOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.getLottoLowerBound(),
                Lotto.getLottoUpperBound(),
                Lotto.getLottoNumberCount());

        return new Lotto(numbers);
    }

}
