package lotto;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.domain.Price;
import lotto.ui.Input;
import lotto.ui.Output;

public class Game {

    public static void start() {
        Price price = Input.readBuyPrice();
        Output.printBoughtAmount(price);

        List<Lotto> lottos = makeLottos(price.getAmount());
        Output.printLottos(lottos);

        Lotto winLotto = Input.readWinningNumbers();
        Bonus bonus = Input.readBonusNumber(winLotto);

        List<Rank> ranks = findRanks(lottos, winLotto, bonus);
        EnumMap<Rank, Integer> result = getGameResult(ranks);
        Output.printGameResult(result);

        double revenueRate = getRevenueRate(price, result);
        Output.printRevenueRate(revenueRate);
    }

    private static List<Lotto> makeLottos(long amount) {
        List<Lotto> lottos = new ArrayList<>();
        for (long i = 0; i < amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottos.add(lotto);
        }
        return lottos;
    }

    private static List<Rank> findRanks(List<Lotto> lottos, Lotto winLotto, Bonus bonus) {
        List<Rank> ranks = new ArrayList<>();
        for (Lotto lotto : lottos) {
            int matchCount = countMatchCount(lotto, winLotto);
            Boolean isMatchBonus = checkMatchBonus(lotto, bonus);
            Rank rank = Rank.findRank(matchCount, isMatchBonus);
            if (rank != null) {
                ranks.add(rank);
            }
        }
        return ranks;
    }

    private static int countMatchCount(Lotto lotto, Lotto winLotto) {
        int matchCount = 0;
        for (Integer number : lotto.getNumbers()) {
            if (winLotto.getNumbers().contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    private static Boolean checkMatchBonus(Lotto lotto, Bonus bonus) {
        for (Integer number : lotto.getNumbers()) {
            if (number == bonus.getBonusNumber()) {
                return true;
            }
        }
        return false;
    }

    private static EnumMap<Rank, Integer> getGameResult(List<Rank> ranks) {
        EnumMap<Rank, Integer> result = new EnumMap<>(Rank.class);
        for (Rank rank : Rank.values()) {
            result.put(rank, 0); // 초기화
        }

        for (Rank rank : ranks) {
            result.put(rank, result.get(rank) + 1);
        }

        return result;
    }

    private static double getRevenueRate(Price price, EnumMap<Rank, Integer> result) {
        long revenue = 0;
        for (Rank rank : result.keySet()) {
            revenue += rank.getPrizeMoney() * result.get(rank);
        }

        return (double) revenue / (double) price.getPrice() * 100;
    }
}
