package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {

    public List<Lotto> buy(int purchaseQuantity) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < purchaseQuantity; i++) {
            lottoTickets.add(Lotto.generate());
        }
        return lottoTickets;
    }
}
