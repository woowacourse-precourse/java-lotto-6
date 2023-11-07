package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoStoreService {
    private final LottoGeneratorService lottoGeneratorService;

    public LottoStoreService(LottoGeneratorService lottoGeneratorService) {
        this.lottoGeneratorService = lottoGeneratorService;
    }

    public List<Lotto> purchaseLotto(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.affordableCountOfLotto();
        return IntStream.range(0, count)
                .mapToObj(i -> lottoGeneratorService.generateLotto())
                .collect(Collectors.toList());
    }
}
