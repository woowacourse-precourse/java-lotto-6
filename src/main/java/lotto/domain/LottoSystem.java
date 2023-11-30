package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

import static lotto.domain.WinningResult.getWinningMoney;
import static lotto.utils.system.LottoSystemUtils.*;

public class LottoSystem {
    private static long purchaseMoney;
    private static List<Lotto> purchaseLottos;

    public LottoSystem(long money) {
        this.purchaseMoney = money;
        this.purchaseLottos = createLottos();
    }

    public List<Lotto> getPurchaseLottos() {
        return purchaseLottos;
    }

    public int getPurchaseLottoCount() {
        return purchaseLottos.size();
    }

    public static float calculateRateOfReturn(Map<WinningResult, Integer> result) {
        long winningMoney = calculateWinningMoney(result);
        return (float) winningMoney / purchaseMoney * 100;
    }

    public Map<WinningResult, Integer> compareWinningLotto(WinningLotto winningLotto) {
        Map<WinningResult, Integer> result = new HashMap<>();

        for (Lotto lotto : purchaseLottos) {
            WinningResult winning = winningLotto.compare(lotto);
            result.put(winning, result.getOrDefault(winning, 0)+1);
        }

        return result;
    }

    private static long calculateWinningMoney(Map<WinningResult, Integer> result) {
        return result.entrySet()
                .stream()
                .mapToLong(entry -> getWinningMoney(entry.getKey()))
                .sum();
    }

    private List<Lotto> createLottos() {
        List<Lotto> lottos = new ArrayList<>();

        long purchaseLottoCnt = purchaseMoney / MONEY_UNIT;
        while (purchaseLottoCnt --> 0) {
            lottos.add(new Lotto(createRandomNumbers()));
        }

        return lottos;
    }

    private List<Integer> createRandomNumbers() {
        return Randoms.pickUniqueNumbersInRange(LOTTO_NUMBER_MIN_RANGE, LOTTO_NUMBER_MAX_RANGE, LOTTO_CNT);
    }
}
