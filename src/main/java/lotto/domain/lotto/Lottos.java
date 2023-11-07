package lotto.domain.lotto;

import java.util.Collections;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;
import lotto.domain.money.LottoMoney;

public record Lottos(List<Lotto> lottos) {

    public static Lottos createFrom(final Supplier<List<Integer>> numbersSupplier, final LottoMoney lottoMoney) {
        int buyingCount = lottoMoney.calculateBuyingCount();
        return new Lottos(Stream.generate(numbersSupplier)
                .limit(buyingCount)
                .map(Lotto::createFrom)
                .toList());
    }

    @Override
    public List<Lotto> lottos() {
        return Collections.unmodifiableList(lottos);
    }

    public List<LottoRewardCondition> createCompareResults(final WinningLotto winningLotto) {
        return lottos.stream()
                .map(winningLotto::findCompareResult)
                .toList();
    }
}
