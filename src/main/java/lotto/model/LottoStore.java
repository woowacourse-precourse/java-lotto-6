package lotto.model;

import lotto.constant.Ranking;
import java.util.ArrayList;
import java.util.List;

public class LottoStore {
    public List<Integer> rankLottos(List<Lotto> customerLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> lottoRank = new ArrayList<>(List.of(0, 0, 0, 0, 0, 0));
        for (Lotto customer : customerLotto) {
            int matchNumber = compareLotto(customer.getNumbers(), winningLotto.getNumbers(), bonusNumber);
            lottoRank.set(
                    setRanking(matchNumber),
                    lottoRank.get(setRanking(matchNumber)) + 1
            );
        }
        return lottoRank;
    }

    private int compareLotto(List<Integer> customerLotto, List<Integer> winningLotto, int bonusNumber) {
        int matchCount = 0;
        for (int i = 0; i < customerLotto.size(); i++) {
            if (winningLotto.contains(customerLotto.get(i))) {
                matchCount++;
            }
        }
        if (matchCount == 5 && isBonusInNumbers(customerLotto, bonusNumber)) {
            matchCount = 7;
        }

        return matchCount;
    }

    private int setRanking(int matchNumber) {
        int flag = 0;
        if (matchNumber == 3) {
            flag = Ranking.MATCH_THREE.getValue();
        } else if (matchNumber == 4) {
            flag = Ranking.MATCH_FOUR.getValue();
        } else if (matchNumber == 5) {
            flag = Ranking.MATCH_FIVE.getValue();
        } else if (matchNumber == 6) {
            flag = Ranking.MATCH_SIX.getValue();
        } else if (matchNumber == 7) {
            flag = Ranking.MATCH_BONUS.getValue();
        }
        return flag;
    }

    private boolean isBonusInNumbers(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }
}
