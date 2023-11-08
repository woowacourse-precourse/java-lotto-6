package lotto.model;

import java.util.List;

public class HitNumberCalculator {

    public int hitNumberCounter(List<Integer> purchasedLottoNumbers, List<Integer> winningLottoNumbers) {
        return (int) purchasedLottoNumbers.stream()
                .filter(winningLottoNumbers::contains)
                .count();
    }

    public boolean isBonusNumberIncluded(List<Integer> purchasedLottoNumbers, int bonusNumber) {
        return purchasedLottoNumbers.contains(bonusNumber);
    }
}