package lotto.domain;

import java.util.List;
import java.util.Objects;
import lotto.Lotto;

public class LottoBundle {
    private final List<Lotto> lotteries;

    public LottoBundle(List<List<Integer>> lotteries) {
        this.lotteries = createLottos(lotteries);
    }

    private List<Lotto> createLottos(List<List<Integer>> lotteries) {
        return lotteries.stream().map(Lotto::new).toList();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoBundle that = (LottoBundle) o;
        return Objects.equals(lotteries, that.lotteries);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lotteries);
    }
}
