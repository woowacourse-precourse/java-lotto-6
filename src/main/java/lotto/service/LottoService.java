package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;
import lotto.domain.Rank;
import lotto.domain.WinningLotto;

public class LottoService {

    public ArrayList<Lotto> generateLotto(PurchaseAmount purchaseAmount) {
        ArrayList<Lotto> lottos = new ArrayList<>();

        int count = purchaseAmount.getMoney() / 1000;

        for (int i = 0; i < count; i++) {
            Lotto lotto = new Lotto(generateLottoNumbers());
            lottos.add(lotto);
        }

        return lottos;
    }

    public List<Integer> generateLottoNumbers() {
        List<Integer> numbers = pickUniqueNumbersInRange(1, 45, 6);
        Collections.sort(numbers);
        return numbers;
    }

    public Map<Rank, Integer> generateLottoStatistics(WinningLotto winningLotto, ArrayList<Lotto> lottos) {
        Map<Rank, Integer> rankCount = new HashMap<>();

        for (Lotto lotto : lottos) {
            Rank rank = winningLotto.calculateRank(lotto);
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }

        return rankCount;
    }

    public double calculateProfitRate(Map<Rank, Integer> rankCount, PurchaseAmount purchaseAmount) {
        int totalWinningAmount = 0;

        for (Rank rank : Rank.values()) {
            totalWinningAmount += rank.getWinningAmount() * rankCount.getOrDefault(rank, 0);
        }

        return (double) totalWinningAmount / (double) purchaseAmount.getMoney() * 100.0;
    }
}