package lotto.Service;

import java.util.ArrayList;
import java.util.List;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Statistics;
import lotto.model.WinnerNumber;

public class CompareService {

    public List<Statistics> calculateMatching(List<Lotto> lottos, WinnerNumber winnerNumber, BonusNumber bonusNumber) {
        List<Statistics> result = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = countMatchingNumbers(lotto.getNumbers(), winnerNumber.getWinnerNumbers());
            boolean matchBonus = isMatchingBonusNumber(lotto.getNumbers(), bonusNumber.getBonusNumber());
            result.add(new Statistics(matchCount, matchBonus));
        }
        return result;
    }

    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> winnerNumbers) {
        int count = 0;
        for (Integer lottoNumber : lottoNumbers) {
            if (winnerNumbers.contains(lottoNumber)) {
                count++;
            }
        }
        return count;
    }

    private boolean isMatchingBonusNumber(List<Integer> lotto, int bonusNumber) {
        for (Integer number : lotto) {
            if (number.equals(bonusNumber)) {
                return true;
            }
        }
        return false;
    }
}
