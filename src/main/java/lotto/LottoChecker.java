package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoChecker {

    //로또 맞는 번호 확인하기
    public List<LottoResult> checkLottoNumbers(List<Lotto> lotto, List<Integer> numbers, int bonusNumber) {
        List<LottoResult> winningNumbers = new ArrayList<>();

        for (int i = 0; i < lotto.size(); i++) {
            winningNumbers.add(checkWinningNumbers(lotto.get(i).getNumbers(), numbers, bonusNumber));
        }

        return winningNumbers;
    }

    //로직
    public LottoResult checkWinningNumbers(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusNumber) {
        int count = 0;
        boolean isBonusMatch = false;

        for (int i = 0; i < winningNumbers.size(); i++) {
            if (lottoNumbers.contains(winningNumbers.get(i))) {
                count++;
            }
            if (lottoNumbers.get(i).intValue() == bonusNumber) {
                isBonusMatch = true;
            }
        }

        return new LottoResult(count,isBonusMatch);
    }
}
