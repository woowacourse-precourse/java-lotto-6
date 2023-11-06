package lotto.module.store;

import lotto.module.domain.PurchaseAmount;
import lotto.module.domain.lotto.Lotto;
import lotto.module.domain.lotto.LottoNumberGenerator;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 구매를 할 수 있는 클래스
 */
public class LottoStore {
    private final LottoTicketQuantityCalculator lottoTicketQuantityCalculator;
    private final LottoNumberGenerator lottoNumberGenerator;

    private LottoStore(LottoTicketQuantityCalculator lottoTicketQuantityCalculator, LottoNumberGenerator lottoNumberGenerator) {
        this.lottoTicketQuantityCalculator = lottoTicketQuantityCalculator;
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public static LottoStore of(LottoTicketQuantityCalculator lottoTicketQuantityCalculator, LottoNumberGenerator lottoNumberGenerator) {
        return new LottoStore(lottoTicketQuantityCalculator, lottoNumberGenerator);
    }

    public List<Lotto> purchaseLotto(PurchaseAmount purchaseAmount) {
        int purchaseQuantity = lottoTicketQuantityCalculator.computeLottoTicketCount(purchaseAmount);

        return IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> lottoNumberGenerator.generateLottoNumber())
                .collect(Collectors.toList());
    }

}
