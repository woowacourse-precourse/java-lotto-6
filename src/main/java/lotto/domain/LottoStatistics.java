package lotto.domain;

import java.util.List;


public class LottoStatistics {

    public int compareLottoNumbersWithWinnerNumbers(Lotto lottoNumbers, Lotto winnerNumbers) {

        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        List<Integer> winNumbers = winnerNumbers.getLottoNumbers();
        int winCount = 0;
        for (int i = 0; i < winNumbers.size(); i++) {
            if (numbers.contains(winNumbers.get(i))) {
                winCount++;
            }
        }
        return winCount;
    }

    public String compareLottoNumbersWithBonusNumber(Lotto lottoNumbers, int bonusNumber) {
        List<Integer> numbers = lottoNumbers.getLottoNumbers();
        if (numbers.contains(bonusNumber)) {
            return "Bonus";
        }
        return "NoBonus";
    }


}
