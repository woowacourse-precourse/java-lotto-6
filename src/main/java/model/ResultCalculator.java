package model;

import java.util.List;

public class ResultCalculator {

    public int hitNumberCounter(List<Integer> purchasedLottoNumbers,
            List<Integer> winningLottoNumbers) {

        int count = 0;
        for (int purchasedLottoNumber : purchasedLottoNumbers) {
            if (winningLottoNumbers.contains(purchasedLottoNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean isBonusNumberIncluded(List<Integer> purchasedLottoNumbers, int bonusNumber) {
        return purchasedLottoNumbers.contains(bonusNumber);
    }
}