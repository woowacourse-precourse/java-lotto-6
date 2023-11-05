package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LottoChecker {
    public int compare(Lotto purchaseLotto, Lotto winningLotto) {
        int count = 0;

        for (int i = 0; i < 6; i++) {
            if (purchaseLotto.getNumbers().contains(winningLotto.getNumbers().get(i))) {
                count++;
            }
        }

        return count;
    }

    public List<Integer> compareLottoTickets(List<Lotto> purchaseLottoTickets, Lotto winningLotto, int bonusNumber) {
        List<Integer> counts = new ArrayList<>();

        for (int i = 0; i < purchaseLottoTickets.size(); i++) {
            int count = compare(purchaseLottoTickets.get(i), winningLotto);
            if (count == Lotto.Prize.THIRD.getMatchCount() && includeBonusNumberInLottoNumber(purchaseLottoTickets.get(i), bonusNumber)) {
                count = Lotto.Prize.SECOND.getMatchCount();
            }
            counts.add(count);
        }

        return counts;
    }

    public boolean includeBonusNumberInLottoNumber(Lotto lotto, int bonusNumber) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public List<Integer> lottoResult(List<Integer> counts) {
        List<Integer> result = new ArrayList<>();
        for (Lotto.Prize prize : Lotto.Prize.values()) {
            result.add(Collections.frequency(counts, prize.getMatchCount()));
        }
        return result;
    }
}
