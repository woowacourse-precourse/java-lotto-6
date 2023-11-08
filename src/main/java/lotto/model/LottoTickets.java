package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoTickets {
    private final static int NUMBERS_SIZE = 6;
    private final static int MIN_NUMBER = 1;
    private final static int MAX_NUMBER = 45;

    private final List<Lotto> tickets = new ArrayList<>();

    public LottoTickets(int purchaseCount) {
        createLottoTickets(purchaseCount);
    }

    private void createLottoTickets(int purchaseCount) {
        for (int i = 0; i < purchaseCount; i++) {
            tickets.add(new Lotto(generateRandomLottoNumbers()));
        }
    }

    private List<Integer> generateRandomLottoNumbers() {
        return Randoms.pickUniqueNumbersInRange(MIN_NUMBER, MAX_NUMBER, NUMBERS_SIZE);
    }

    public List<Lotto> getTickets() {
        return tickets;
    }
}
