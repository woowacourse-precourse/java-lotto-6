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

    public List<Integer> compareLottoTickets(List<Lotto> purchaseLottoTickets, Lotto winningLotto, int bonusNumber) {
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < purchaseLottoTickets.size(); i++) {
            int count = compare(purchaseLottoTickets.get(i), winningLotto);
            if (count == 5 && includeBonusNumberInLottoNumber(purchaseLottoTickets.get(i), bonusNumber)) {
                count++;
            }
            counts.add(count);
        }

        return counts;
    }

    public boolean includeBonusNumberInLottoNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
