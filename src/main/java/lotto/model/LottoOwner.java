package lotto.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lotto.constant.LottoRanking;
import lotto.dto.LottosInfo;
import lotto.dto.WinningStatistics;
import lotto.generator.IntegerListGenerator;

public class LottoOwner {
    private final PurchasePrice purchasePrice;
    private final List<Lotto> lottos;
    private final Map<LottoRanking, Integer> lottoResults = new HashMap<>();

    private LottoOwner(PurchasePrice purchasePrice, List<Lotto> lottos) {
        this.purchasePrice = purchasePrice;
        this.lottos = lottos;
        initLottoResults();
    }

    public static LottoOwner of(PurchasePrice purchasePrice, IntegerListGenerator generator) {
        List<Lotto> randomLottos = new ArrayList<>();
        long quotient = purchasePrice.getQuotient();
        while (quotient-- != 0) {
            randomLottos.add(Lotto.from(generator.generateIntegerList()));
        }
        return new LottoOwner(purchasePrice, randomLottos);
    }

    private void initLottoResults() {
        Arrays.stream(LottoRanking.values())
                .forEach(ranking -> lottoResults.put(ranking, 0));
    }

    public LottosInfo getLottosInfo() {
        List<String> lottosText = lottos.stream()
                .map(Lotto::toString)
                .toList();
        return new LottosInfo(lottosText);
    }

    public WinningStatistics matchLottosWithWinningLotto(WinningLotto winningLotto) {
        lottos.forEach(lotto -> {
            LottoRanking lottoRanking = winningLotto.calculateLottoRanking(lotto);
            if (Objects.nonNull(lottoRanking)) {
                lottoResults.put(lottoRanking, lottoResults.get(lottoRanking) + 1);
            }
        });
        return new WinningStatistics(lottoResults);
    }
}
