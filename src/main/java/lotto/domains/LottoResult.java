package lotto.domains;

import java.util.List;
import lotto.constants.LottoRank;

public class LottoResult {

    private static Purchase purchase = null;
    private static WinningLotto winningLotto = null;

    public LottoResult(Purchase purchase, WinningLotto winningLotto) {
        this.purchase = purchase;
        this.winningLotto = winningLotto;
    }

    public static int[] analyze() {
        int[] result = new int[6];

        for (Lotto purchaseLotto : purchase.getLottos()) {
            int matchCount = getMatchCount(purchaseLotto, winningLotto.getWinningNumbers());

            if (matchCount < 3) {
                continue;
            }

            LottoRank lottoRank = getRankByMatchingNumbers(matchCount);

            if ((lottoRank.getRank() == LottoRank.FIFTH.getRank())
                    && (containBonusNumber(purchaseLotto,
                    winningLotto.getBonusNumber()))) {
                lottoRank = LottoRank.BONUS;
            }

            result[lottoRank.getRank()]++;
        }

        return result;
    }

    private static int getMatchCount(Lotto purchaseLotto, Lotto winningLotto) {
        int matchCount = 0;

        List<Integer> purchaseNumbers = purchaseLotto.getNumbers();
        List<Integer> winningNumbers = winningLotto.getNumbers();
        for (int purchaseNumber : purchaseNumbers) {
            if (winningNumbers.contains(purchaseNumber)) {
                matchCount++;
            }
        }

        return matchCount;
    }

    private static boolean containBonusNumber(Lotto purchaseLotto, int bonusNumber) {
        List<Integer> purchaseNumbers = purchaseLotto.getNumbers();
        if (purchaseNumbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }

    private static LottoRank getRankByMatchingNumbers(int matchingNumbers) throws IllegalArgumentException {
        for (LottoRank lottoRank : LottoRank.values()) {
            if (lottoRank.getMatchingNumbers() == matchingNumbers) {
                return lottoRank;
            }
        }
        return null;
    }


}
