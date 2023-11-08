package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static lotto.Constant.*;

public class LottoService {

    public List<Lotto> generateLottos(int purchaseAmount) {
        int lottoNum = purchaseAmount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for(int i=0; i<lottoNum; i++) {
            List<Integer> lottoNums = Randoms.pickUniqueNumbersInRange(MIN_NUM, MAX_NUM, LOTTO_NUM_COUNT);
            lottos.add(new Lotto(lottoNums));
        }
        return lottos;
    }

    public List<Integer> getResults(List<Lotto> purchasedLottos, List<Integer> winnerNums, int bonusNum) {
        List<Integer> results = new ArrayList<>(Collections.nCopies(Result.values().length, 0));
        for (Lotto lotto : purchasedLottos) {
            Result result = lotto.match(winnerNums, bonusNum);
            int idx  = result.ordinal();
            results.set(idx, results.get(idx) + 1);
        }
        return results;
    }

    public double calculateEarningRate(List<Integer> results, int purchaseAmount) {
        double totalEarning = 0;
        for (Result result : Result.values()) {
            totalEarning += results.get(result.ordinal()) * result.getEarnings();
        }
        return (totalEarning / purchaseAmount) * 100;
    }
}
