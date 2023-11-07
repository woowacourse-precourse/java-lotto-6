package domain.LottoTicket;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.Lotto;

import java.util.ArrayList;
import java.util.List;

public class PaymentCalculator {
    public static List<LottoTicket> purchaseLottoTickets(int amount) {
        int numberOfLotto = amount / 1000;
        List<LottoTicket> lottoTickets = new ArrayList<>();

        for (int i = 0; i < numberOfLotto; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Lotto> lottos = new ArrayList<>();
            lottos.add(new Lotto(numbers));
            lottoTickets.add(new LottoTicket(lottos));
        }

        return lottoTickets;
    }
}
