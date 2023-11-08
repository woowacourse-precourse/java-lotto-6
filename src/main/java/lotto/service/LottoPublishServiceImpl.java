package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.domain.Amount;
import lotto.domain.LottoCollector;
import lotto.utils.RandomPicker;

public class LottoPublishServiceImpl implements LottoPublishService {

    private final Amount amount;

    public LottoPublishServiceImpl() {
        this.amount = new Amount();
    }

    @Override
    public LottoCollector publish(int purchaseAmount) {
        int lottoTicketCount = calculateLottoTicketCount(purchaseAmount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoTicketCount; i++) {
            lottos.add(new Lotto(RandomPicker.randomLottoNumbers()));
        }
        return new LottoCollector(lottos);
    }

    private int calculateLottoTicketCount(int purchaseAmount) {
        return amount.calculateTotalLottoCount(purchaseAmount);
    }
}
