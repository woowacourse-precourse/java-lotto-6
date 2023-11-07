package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import java.util.stream.IntStream;
import lotto.vo.PurchaseAmount;
import lotto.vo.PurchasePrice;

public class LottoBuyer {

    protected PurchaseAmount getPurchaseAmount(final PurchasePrice purchasePrice) {
        return new PurchaseAmount(purchasePrice.getPrice());
    }

    protected List<Lotto> purchaseLottos(final int count) {
        return IntStream.range(0, count)
                .mapToObj(index -> purchaseOneLotto())
                .toList();
    }

    private Lotto purchaseOneLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                Lotto.getLottoLowerBound(),
                Lotto.getLottoUpperBound(),
                Lotto.getLottoNumberCount());

        return new Lotto(numbers);
    }

}
