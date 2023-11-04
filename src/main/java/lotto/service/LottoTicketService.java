package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.model.Lotto;
import lotto.model.collections.LottoPurchaseAmount;
import lotto.model.collections.LottoTicketCount;

import java.util.List;

import static lotto.constant.LottoConfig.*;

public class LottoTicketService {
    private final int startInclusive = LOTTO_START_NUMBER.getValue();
    private final int endInclusive = LOTTO_END_NUMBER.getValue();
    private final int count = LOTTO_COUNT_NUMBER.getValue();

    public LottoTicketCount convertMoneyToTickets(LottoPurchaseAmount purchaseAmount) {
        int ticketCountValue = purchaseAmount.getAmount() / TICKET_PRICE.getValue();
        return new LottoTicketCount(ticketCountValue);
    }

    public Lotto generateSingleLottoNumbers() {
        List<Integer> lottoNumbers = Randoms.pickUniqueNumbersInRange(startInclusive, endInclusive, count);
        return new Lotto(lottoNumbers);
    }
}
