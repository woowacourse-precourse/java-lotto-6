package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoGame {

    public List<Lotto> buyLottos(int lottoCounts) {
        System.out.println("\n" + lottoCounts + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCounts; i++) {
            Lotto lotto = new Lotto(generateLottoNums());
            lottos.add(lotto);
            System.out.println(lotto);
        }
        return lottos;
    }

    public List<Integer> generateLottoNums() {
        return Randoms.pickUniqueNumbersInRange(1, 45, 6)
                .stream()
                .sorted()
                .toList();
    }

    public int getLottoCounts(int price) {
        return price / 1000;
    }

    public void printResult(List<Rank> ranks) {
        Map<Rank, Integer> rankCount = getRankCount(ranks);

        System.out.println("\n당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + rankCount.getOrDefault(Rank.FIFTH, 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + rankCount.getOrDefault(Rank.FOURTH, 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + rankCount.getOrDefault(Rank.THIRD, 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + rankCount.getOrDefault(Rank.SECOND, 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + rankCount.getOrDefault(Rank.FIRST, 0) + "개");
    }

    public Map<Rank, Integer> getRankCount(List<Rank> ranks) {
        Map<Rank, Integer> rankCount = new HashMap<>();
        for (Rank rank : ranks) {
            rankCount.put(rank, rankCount.getOrDefault(rank, 0) + 1);
        }
        return rankCount;
    }

    public void printEarningRate(List<Rank> ranks, int price) {
        System.out.println("총 수익률은 " + getEarningRate(ranks, price) +"입니다.");
    }

    public String getEarningRate(List<Rank> ranks, int price) {
        Integer prizeSum = ranks.stream()
                .map(rank -> rank.name())
                .map(name -> Prize.valueOf(name))
                .map(Prize::getValue)
                .reduce((x, y) -> x + y)
                .get();

        double earningRate = (double) prizeSum / price * 100;

        return String.format("%.1f", earningRate) + "%";
    }
}
