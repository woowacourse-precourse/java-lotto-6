package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoGroup {
    private final List<Lotto> lottos;

    private LottoGroup(List<Lotto> lottos) {
        this.lottos = new ArrayList<>(lottos);
    }

    public static LottoGroup create(PurchasableLottoCount purchasableLottoCount, NumberGenerator numberGenerator) {
        List<Lotto> lottos = createLottos(purchasableLottoCount, numberGenerator);
        return new LottoGroup(lottos);
    }

    private static List<Lotto> createLottos(PurchasableLottoCount purchasableLottoCount,
                                            NumberGenerator numberGenerator) {
        return Stream.generate(() -> Lotto.create(numberGenerator))
                .limit(purchasableLottoCount.getCount())
                .toList();
    }

    public TotalPrize calculateTotalPrize(WinningTicket winningTicket) {
        Map<LottoPrize, Long> totalPrize = lottos.stream()
                .map(lotto -> lotto.calculatePrize(winningTicket))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        return TotalPrize.from(totalPrize);
    }

    public List<Lotto> getLottos() {
        return new ArrayList<>(lottos);
    }
}
