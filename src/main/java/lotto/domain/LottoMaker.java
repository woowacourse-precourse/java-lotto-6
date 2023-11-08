package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {

    public List<Lotto> makeLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6);
    }

    public int calculateLottoTicketCount(int money) {
        return money / 1000;
    }
}
