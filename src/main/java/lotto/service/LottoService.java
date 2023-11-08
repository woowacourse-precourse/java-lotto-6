package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Ranking;

public class LottoService {
    private static Lotto createLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return new Lotto(numbers);
    }

    public static Lottos createLottos(int price) {
        int buyCount = price / 1000;
        List<Lotto> lottos = new ArrayList<>();
        for(int i = 0; i < buyCount; i++) {
            lottos.add(createLotto());
        }
        return new Lottos(lottos, buyCount);
    }

    private static int getMatchingCount(List<Integer> lotto, List<Integer> winningNum) {
        int matchCount = 0;
        for(Integer i : lotto) {
            if(winningNum.contains(i)) {
                matchCount++;
            }
        }
        return matchCount;
    }
    private static boolean getMatchingBonusNumber(int bonusNum, List<Integer> winningNum) {
        return winningNum.contains(bonusNum);
    }

    private static Ranking getRanking(List<Integer> lotto, List<Integer> winningNum, int bonusNum) {
        int matchingCount = getMatchingCount(lotto, winningNum);
        if(matchingCount == 6)
            return Ranking.FIRST;
        if(matchingCount == 5){
            if(getMatchingBonusNumber(bonusNum, winningNum))
                return Ranking.SECOND;
            return Ranking.THIRD;
        }
        if(matchingCount == 4)
            return Ranking.FOURTH;
        if(matchingCount == 3)
            return Ranking.FIFTH;
        return Ranking.NONE;
    }
    public static double calculateIncome(int price, EnumMap<Ranking, Integer> ranking) {
        int total = 0;
        for(Ranking r : Ranking.values()) {
            int count = ranking.get(r);
            if (count > 0) {
                total += r.getWinningMoney() * count;
            }
        }
        return (double)total / price * 100;
    }

    public static EnumMap<Ranking, Integer> getResult(Lottos lottos, List<Integer> winningNumber, int bonusNumber) {
        EnumMap<Ranking, Integer> result = new EnumMap<Ranking, Integer>(Ranking.class);
        for(Ranking ranking : Ranking.values()) {
            result.put(ranking, 0);
        }
        for(Lotto lotto : lottos.getLottos()) {
            Ranking ranking = getRanking(lotto.getNumbers(), winningNumber, bonusNumber);
            result.put(ranking, result.get(ranking) + 1);
        }
        return result;
    }
}
