package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class LottoMaker {
    private static final int LOTTO_SIZE = 6;
    private static final int MIN_RANGE = 1;
    private static final int MAX_RANGE = 45;
    private static final int LOTTO_PRICE = 1000;


    public List<Lotto> makeLottoTickets(int ticketCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            Lotto lotto = new Lotto(createRandomNumber());
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    public List<Integer> createRandomNumber() {
        return Randoms.pickUniqueNumbersInRange(MIN_RANGE, MAX_RANGE, LOTTO_SIZE);
    }

    public int calculateLottoTicketCount(int money) {
        return money / LOTTO_PRICE;
    }
}
