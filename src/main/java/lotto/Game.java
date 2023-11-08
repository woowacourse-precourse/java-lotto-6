package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static lotto.Rank.getRank;

public class Game {

    public void startGame() {
        int price = Display.readUntilValidPrice();
        int issueCnt = price / 1000;
        List<Lotto> issuedLottos = issueLottos(issueCnt);
        Display.showIssuedLottos(issuedLottos);
        Lotto winningNumbers = Display.readUntilValidWinningNumbers();
        Bonus bonus = Display.readUntilValidBonusNumber(winningNumbers);
        Map<Rank, Integer> resultRanks = assignEachRank(winningNumbers, bonus, issuedLottos);
        Display.showRanks(resultRanks);
        Display.showStatistics(getRevenueRate(price, resultRanks));
    }

    private double getRevenueRate(int price, Map<Rank, Integer> resultRanks) {
        int totalRevenue = 0;
        for(Rank rank : resultRanks.keySet()) {
            totalRevenue += rank.price * resultRanks.get(rank);
        }
        return Math.round((double) totalRevenue / price * 1000) / 10.0;
    }

    private Map<Rank, Integer> assignEachRank(Lotto winningNumbers, Bonus bonus, List<Lotto> issuedLottos) {
        Map<Rank, Integer> results = new HashMap<>();
        for(Lotto lotto : issuedLottos) {
            Rank rank = getRank(winningNumbers, bonus, lotto);
            if(rank == null) {
                continue;
            }
            results.put(rank, results.getOrDefault(rank, 0) + 1);
        }
        return results;
    }

    public List<Lotto> issueLottos(int issueCnt) {
        List<Lotto> lottos = new ArrayList<>();
        while(lottos.size() < issueCnt) {
            try {
                lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
            } catch (IllegalArgumentException ignored) {}
        }
        return lottos;
    }
}
