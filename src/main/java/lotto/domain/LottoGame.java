package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.consts.Consts;
import lotto.enums.Prize;
import lotto.enums.Rank;

import java.util.*;

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
        return Randoms.pickUniqueNumbersInRange(Consts.MIN_RANGE, Consts.MAX_RANGE, Consts.LOTTO_NUM_COUNT)
                .stream()
                .sorted()
                .toList();
    }

    public int getLottoCounts(int price) {
        return price / Consts.UNIT;
    }

    public void printResult(List<Rank> ranks) {
        Map<Rank, Integer> rankCount = getRankCount(ranks);

        System.out.println("\n당첨 통계\n---");

        List<Rank> rankValues = new ArrayList(List.of(Rank.values()));
        Collections.reverse(rankValues);
        rankValues.stream()
                    .filter(rank -> !rank.equals(Rank.OTHER))
                    .forEach(rank -> System.out.println(
                        rank.getCorrectCount() + "개 일치"
                        + (rank.isBonusCorrect() ? ", 보너스 볼 일치" : "")
                        + " (" + Prize.valueOf(rank.name()).getPrintValue() + "원) - "
                        + rankCount.getOrDefault(rank, 0) + "개"
                    ));
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

        double earningRate = (double) prizeSum / price * Consts.HUNDRED;

        return String.format("%.1f", earningRate) + "%";
    }
}
