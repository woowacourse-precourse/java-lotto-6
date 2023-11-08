package lotto.domain;

import java.util.List;

// LottoCompae
// ### ☑️ 로또 번호 비교 기능
// - 발행한 로또 번호와 당첨 번호가 일치하는 개수를 계산한다.


public class LottoMatching {

    private int matchingCount;

    public void matchingNumber(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        matchingCount = 0;
        for (int i = 0; i < lottoNumbers.size(); i++) {
            if (winningNumbers.contains(lottoNumbers.get(i))) {
                matchingCount++;
            }
        }
    }

    public void checkBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        if (matchingCount == 5 && lottoNumbers.contains(bonusNumber)) {
            matchingCount *= 0;
        }
    }

    public int getMatchingCount() {
        return matchingCount;
    }
}
