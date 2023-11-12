package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class LottoWinning {

    public static List<LottoRanking> winningCheck(List<Lotto> purchasedLottos, List<Integer> winningNumbers,
            int bonusNumber) {

        List<LottoRanking> winnings = new ArrayList<>();

        for (Lotto lottoNumbers : purchasedLottos) {
            LottoRanking lottoRanking = countMatchingNumbers(lottoNumbers.getNumbers(), winningNumbers, bonusNumber);
            winnings.add(lottoRanking);
        }

        return winnings;
    }

    private static LottoRanking countMatchingNumbers(List<Integer> purchasedNumbers, List<Integer> winningNumbers,
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
