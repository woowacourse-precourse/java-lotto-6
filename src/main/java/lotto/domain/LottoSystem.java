package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.domain.WinningResult.getWinningMoney;
import static lotto.utils.LottoSystemUtils.*;

public class LottoSystem {
    private static int purchaseMoney;
    private static List<Lotto> purchaseLottos;

    public LottoSystem(int money) {
        this.purchaseMoney = money;
        this.purchaseLottos = createLottos();
    }

    public static float calculateRateOfReturn(List<WinningResult> results) {
        long winningMoney = calculateWinningMoney(results);
        return Math.round((float) winningMoney / purchaseMoney * 1000) / 10f;
    }

    private static long calculateWinningMoney(List<WinningResult> results) {
        return results.stream()
                .mapToInt(WinningResult::getWinningMoney)
                .sum();
    }

    public static List<WinningResult> compareWinningLotto(WinningLotto winningLotto) {
        List<WinningResult> result = new ArrayList<>();

        for (Lotto lotto : purchaseLottos) {
            result.add(winningLotto.compare(lotto));
        }

        return result;
    }

    public static List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }

    public static int getPurchaseLottoCount() {
        return purchaseLottos.size();
    }

    private static List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();

        int purchaseLottoCnt = purchaseMoney / moneyUnit;
        while (purchaseLottoCnt --> 0) {
            lottos.add(new Lotto(createRandomNumbers()));
        }

        return lottos;
    }

    private static List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(lottoNumberMinArrange, lottoNumberMaxArrange, lottoCount);
    }
}
