package lotto.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public final class LottoGroup {
    private final List<Lotto> purchasedLottos;

    LottoGroup(List<Lotto> purchasedLottos) {
        this.purchasedLottos = new ArrayList<>(purchasedLottos);
    }

    public static LottoGroup create(PurchasableLottoCount purchasableLottoCount, NumberGenerator numberGenerator) {
        List<Lotto> generatedLottos = generateLottos(purchasableLottoCount, numberGenerator);

        return new LottoGroup(generatedLottos);
    }

    private static List<Lotto> generateLottos(PurchasableLottoCount purchasableLottoCount,
                                              NumberGenerator numberGenerator) {
        return Stream.generate(() -> createLotto(numberGenerator))
                .limit(purchasableLottoCount.getCount())
                .toList();
    }

    private static Lotto createLotto(NumberGenerator numberGenerator) {
        return Lotto.create(numberGenerator);
    }

    public PrizeSummary generatePrizeSummary(WinningCombination winningCombination) {
        Map<LottoPrize, Long> prizeSummary = calculatePrizeSummary(winningCombination);

        return PrizeSummary.from(prizeSummary);
    }

    private Map<LottoPrize, Long> calculatePrizeSummary(WinningCombination winningCombination) {
        return purchasedLottos.stream()
                .map(lotto -> lotto.determineLottoPrize(winningCombination))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }

    public List<Lotto> getPurchasedLottos() {
        return new ArrayList<>(purchasedLottos);
    }
}
