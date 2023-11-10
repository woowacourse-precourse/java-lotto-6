package lotto.domain;

import java.util.List;

public class LottoWinning {

    public void winningCheck(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {

        for (Lotto lottoNumbers : purchasedLottos) {
            LottoRanking lottoRanking = countMatchingNumbers(lottoNumbers.getNumbers(), winningNumbers, bonusNumber);
            System.out.println(lottoRanking);
        }
    }

    private LottoRanking countMatchingNumbers(List<Integer> purchasedNumbers, List<Integer> winningNumbers,
            int bonusNumber) {
        int count = 0;
        for (Integer purchasedNumber : purchasedNumbers) {
            if (winningNumbers.contains(purchasedNumber)) {
                count++;
            }
        }
        if (purchasedNumbers.contains(bonusNumber)) {
            return LottoRanking.valueOf(count, true);
        }
        return LottoRanking.valueOf(count, false);
    }
}
