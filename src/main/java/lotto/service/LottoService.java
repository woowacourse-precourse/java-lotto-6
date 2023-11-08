package lotto.service;

import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MAX;
import static lotto.domain.constants.LottoConfig.LOTTO_NUMBER_MIN;
import static lotto.domain.constants.LottoConfig.LOTTO_SIZE;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Buyer;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {
    public Lottos generateLottoTicket(final Buyer buyer) {
        List<Lotto> lottoTicket = new ArrayList<>();
        while (lottoTicket.size() < buyer.getPurchaseCount()) {
            lottoTicket.add(generateLotto());
        }
        return Lottos.of(lottoTicket);
    }

    private Lotto generateLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < LOTTO_SIZE.getValue()) {
            numbers = Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN.getValue(), LOTTO_NUMBER_MAX.getValue(),
                    LOTTO_SIZE.getValue());
        }
        return new Lotto(numbers);
    }
}
