package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoTicketGenerator {
    LottoTicketGenerator() {
    }

    public Lottos generate(Payment payment) {
        int count = calculateNumberOfLottoTickets(payment);
        System.out.println("\n" + count + "개를 구매했습니다.");

        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(LottoNumber.MIN_NUMBER, LottoNumber.MAX_VALUE,
                    Lotto.NUMBER_COUNT));
            lottoTickets.add(lotto);
        }
        return new Lottos(lottoTickets);
    }

    private int calculateNumberOfLottoTickets(Payment payment) {
        return payment.getValue() / Lotto.PRICE;
    }
}
