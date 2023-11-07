package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    public static final int MINIMUM_NUMBER = 1;
    public static final int MAXIMUM_NUMBER = 45;
    public static final int NUMBER_COUNT = 6;

    public List<Lotto> buy(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoTickets.add(new Lotto(generate()));
        }
        return lottoTickets;
    }

    private List<Integer> generate() {
        return Randoms.pickUniqueNumbersInRange(MINIMUM_NUMBER, MAXIMUM_NUMBER, NUMBER_COUNT);
    }
}
