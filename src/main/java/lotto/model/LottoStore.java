package lotto.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.ArrayList;
import java.util.List;
import lotto.constant.LottoResult;

public class LottoStore {


    public List<Integer> rankLottos(List<Lotto> customerLotto, Lotto winningLotto, int bonusNumber) {
        List<Integer> lottoRank = initializeLottoRank();

        for (Lotto customer : customerLotto) {
            int matchingCount = compareLotto(customer.getNumbers(), winningLotto.getNumbers());
            int matchingRankIndex = setRanking(matchingCount);
            int currentRankCount = lottoRank.get(matchingRankIndex);

            if (isThirdRankWithBonus(customer, matchingRankIndex, bonusNumber)) {
                matchingRankIndex++;
            }
            lottoRank.set(matchingRankIndex, currentRankCount + 1);
        }

        return lottoRank;
    }

    private int compareLotto(List<Integer> customerLotto, List<Integer> winningLotto) {
        Set<Integer> winningNumbers = new HashSet<>(winningLotto);
        int matchCount = 0;
        for (Integer lotto : customerLotto) {
            if (winningNumbers.contains(lotto)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private List<Integer> initializeLottoRank() {
        return new ArrayList<>(Collections.nCopies(6, 0));
    }

    private boolean isThirdRankWithBonus(Lotto lotto, int matchingRankIndex, int bonusNumber) {
        return matchingRankIndex == LottoResult.THIRD_RANK.getIndex() &&
                isBonusInNumbers(lotto.getNumbers(), bonusNumber);
    }

    private boolean isBonusInNumbers(List<Integer> numbers, int bonusNumber) {
        return numbers.contains(bonusNumber);
    }


    private int setRanking(int matchingCount) {
        return switch (matchingCount) {
            case 3 -> LottoResult.FIFTH_RANK.getIndex();
            case 4 -> LottoResult.FOURTH_RANK.getIndex();
            case 5 -> LottoResult.THIRD_RANK.getIndex();
            case 6 -> LottoResult.FIRST_RANK.getIndex();
            default -> 0; // Handle other cases if needed.
        };
    }
}
