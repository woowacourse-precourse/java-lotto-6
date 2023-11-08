package lotto;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LottoNumberReader {

    public static LottoRank checkRanking(Lotto winningLotto, int bonusNumber, Lotto purchasedLotto) {
        Set<Integer> winningNumber = winningLotto.getLottoNumber().stream().collect(Collectors.toSet());
        List<Integer> purchasedLottoNumber = purchasedLotto.getLottoNumber();

        int count = 0;
        for (int number : purchasedLottoNumber) {
            if (winningNumber.contains(number)) {
                count++;
            }
        }

        return LottoRank.getRank(count, containsBonusNumber(bonusNumber, purchasedLottoNumber));
    }

    private static boolean containsBonusNumber(int bonusNumber, List<Integer> lottoNumber) {
        if (lottoNumber.contains(bonusNumber)) {
            return true;
        }

        return false;
    }
}
