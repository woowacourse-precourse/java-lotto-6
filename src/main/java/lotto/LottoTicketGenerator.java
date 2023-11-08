package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    LottoTicketGenerator() {
    }

    public Lottos generate(Amount amount) {
        int count = calculateNumberOfLottoTickets(amount);
        System.out.printf((LottoStringFormat.LOTTO_BUY_COUNT_FORMAT) + "%n", count);

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_VALUE,
                    Lotto.NUMBER_COUNT));
            lottoTickets.add(lotto);
        }
        return new Lottos(lottoTickets);
    }

    private int calculateNumberOfLottoTickets(Amount amount) {
        return amount.getValue() / Lotto.PRICE;
    }
}
