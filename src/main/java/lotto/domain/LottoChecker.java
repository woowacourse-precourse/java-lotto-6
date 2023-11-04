package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {
    public int compare(Lotto purchaseLotto, Lotto winningLotto) {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (purchaseLotto.getNumbers().get(i) == winningLotto.getNumbers().get(i)) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> compareLottoTickets(List<Lotto> purchaseLottoTickets, Lotto winningLotto) {
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < purchaseLottoTickets.size(); i++) {
            int count = compare(purchaseLottoTickets.get(i), winningLotto);
            counts.add(count);
        }

        return counts;
    }
}
