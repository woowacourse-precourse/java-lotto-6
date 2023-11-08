package lotto.module.store;

import lotto.module.domain.PurchaseAmount;
import lotto.module.lotto.Lotto;
import lotto.module.lotto.LottoNumberGenerator;
import lotto.module.lotto.UserLottoTickets;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * 로또 구매를 할 수 있는 클래스
 */
public class LottoStore {
    private final LottoNumberGenerator lottoNumberGenerator;
    private final LottoTicketQuantityCalculator lottoTicketQuantityCalculator;

    private LottoStore(LottoNumberGenerator lottoNumberGenerator, LottoTicketQuantityCalculator lottoTicketQuantityCalculator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
        this.lottoTicketQuantityCalculator = lottoTicketQuantityCalculator;
    }

    public static LottoStore of(LottoNumberGenerator lottoNumberGenerator, LottoTicketQuantityCalculator lottoTicketQuantityCalculator) {
        return new LottoStore(lottoNumberGenerator, lottoTicketQuantityCalculator);
    }

    public UserLottoTickets purchaseLotto(PurchaseAmount purchaseAmount) {
        int purchaseQuantity = lottoTicketQuantityCalculator.computeLottoTicketCount(purchaseAmount);

        List<Lotto> tickets = IntStream.range(0, purchaseQuantity)
                .mapToObj(i -> lottoNumberGenerator.generateLottoNumber())
                .collect(Collectors.toList());

        return UserLottoTickets.newInstance(tickets);
    }

}
