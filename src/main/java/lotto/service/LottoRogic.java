package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.LottoPrize;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;
import lotto.view.PrintMessage;

public class LottoRogic {

    public static void matchWinningLotto(Lottos lottos, WinningLotto winningLotto) {
        Map<LottoPrize, Integer> prizeCount = setInitLottoResult();
        for (Lotto lotto : lottos.getLottos()) {
            boolean bonus = false;
            int count = getMatchCounts(lotto, winningLotto);
            if (count == 5) {
                bonus = getMatchBonus(lotto, winningLotto);
            }
            if (count >= 3) {
                setLottoCount(prizeCount, count, bonus);
            }
        }
        printLottoPrize(prizeCount);
    }

    public static int getMatchCounts(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = 0;
        List<Integer> winningLottoNumbers = winningLotto.getWinningLotto().getNumbers();
        for (Integer number : lotto.getNumbers()) {
            if (winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public static boolean getMatchBonus(Lotto lotto, WinningLotto winningLotto) {
        return lotto.getNumbers().contains(winningLotto.getBonusNumber());
    }

    public static Map setInitLottoResult() {
        Map<LottoPrize, Integer> prizeCount = new EnumMap<>(LottoPrize.class);
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            prizeCount.put(lottoPrize, 0);
        }
        return prizeCount;
    }

    public static Map setLottoCount(Map<LottoPrize, Integer> prizeCount, int count, boolean bonus) {
        if (count == 5 && bonus == true) {
            prizeCount.put(LottoPrize.FIVE_PLUS_BONUS, (prizeCount.get(LottoPrize.FIVE_PLUS_BONUS)) + 1);
        } else if (count == 5) {
            prizeCount.put(LottoPrize.FIVE_MATCHES, (prizeCount.get(LottoPrize.FIVE_MATCHES)) + 1);
        } else if (count == 3) {
            prizeCount.put(LottoPrize.THREE_MATCHES, (prizeCount.get(LottoPrize.THREE_MATCHES)) + 1);
        } else if (count == 4) {
            prizeCount.put(LottoPrize.FOUR_MATCHES, (prizeCount.get(LottoPrize.FOUR_MATCHES)) + 1);
        } else if (count == 6) {
            prizeCount.put(LottoPrize.SIX_MATCHES, (prizeCount.get(LottoPrize.SIX_MATCHES)) + 1);
        }
        return prizeCount;
    }

    public static void printLottoPrize(Map<LottoPrize, Integer> prizeCount) {
        for (LottoPrize lottoPrize : LottoPrize.values()) {
            PrintMessage.printPrizes(lottoPrize, prizeCount.get(lottoPrize));
        }
    }

}
