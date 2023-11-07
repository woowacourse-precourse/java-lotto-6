package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Game {

    public void startGame() {
        int price = Display.readPrice();
        int issueCnt = price / 1000;
        List<Lotto> issuedLottos = issueLottos(issueCnt);
        Display.showIssuedLottos(issuedLottos);
        Lotto winningNumbers = Display.readWinningNumbers();
        Bonus bonus = Display.readBonusNumber(winningNumbers);
        Map<Rank, Integer> resultRanks = assignEachRank(winningNumbers, bonus, issuedLottos);
        Display.showRanks(resultRanks);
//        Display.showStatistics(getRevenueRate(price, resultRanks));
    }

    private double getRevenueRate(int price, List<Rank> resultRanks) {
        int totalRevenue = 0;
        for(Rank rank : resultRanks) {
            totalRevenue += rank.price;
        }
        return Math.round((double) totalRevenue / price * 100) / 100.0;
    }

    private Map<Rank, Integer> assignEachRank(Lotto winningNumbers, Bonus bonus, List<Lotto> issuedLottos) {
        Map<Rank, Integer> results = new HashMap<>();
        for(Lotto lotto : issuedLottos) {
            int matchCnt = winningNumbers.matchLotto(lotto);
            if(matchCnt == 6) {
                results.put(Rank.first, results.getOrDefault(Rank.first, 0) + 1);
            }
            if(matchCnt == 5 && lotto.getNumbers().contains(bonus.getNumber())) {
                results.put(Rank.second, results.getOrDefault(Rank.second, 0) + 1);
                continue;
            }
            if(matchCnt == 5) {
                results.put(Rank.third, results.getOrDefault(Rank.third, 0) + 1);
            }
            if(matchCnt == 4) {
                results.put(Rank.fourth, results.getOrDefault(Rank.fourth, 0) + 1);
            }
            if(matchCnt == 3) {
                results.put(Rank.fifth, results.getOrDefault(Rank.fifth, 0) + 1);
            }
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
