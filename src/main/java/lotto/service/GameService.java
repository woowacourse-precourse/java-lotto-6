package lotto.service;

import static java.lang.Math.round;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import lotto.constant.GameNumber;
import lotto.domain.Lotto;
import lotto.domain.Rank;

public class GameService {
    public List<Lotto> makeLottos(int buyCount) {
        List<Lotto> lottos = new ArrayList<>();

        for (int i = 0; i < buyCount; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }

        return lottos;
    }

    public HashMap<Rank, Integer> getResult(List<Lotto> buyList, Lotto winningNumber, int bonusNumber) {
        HashMap<Rank, Integer> result = new HashMap<>();
        initResult(result);
        Rank rank;

        for (Lotto buy : buyList) {
            List<Integer> numbers = buy.getNumbers();
            rank = checkRank(numbers, winningNumber, bonusNumber);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }

        return result;
    }

    private void initResult(HashMap<Rank, Integer> result) {
        result.put(Rank.FIRST, 0);
        result.put(Rank.SECOND, 0);
        result.put(Rank.THIRD, 0);
        result.put(Rank.FOURTH, 0);
        result.put(Rank.FIFTH, 0);
        result.put(Rank.NO_RANK0, 0);
        result.put(Rank.NO_RANK1, 0);
        result.put(Rank.NO_RANK2, 0);
    }

    private Rank checkRank(List<Integer> numbers, Lotto winningNumber, int bonusNumber) {
        List<Integer> copyNumbers = new ArrayList<>(numbers);
        List<Integer> answer = winningNumber.getNumbers();
        boolean haveBonus = false;

        if (copyNumbers.contains(bonusNumber)) {
            haveBonus = true;
        }
        copyNumbers.retainAll(answer);
        Rank rank = Rank.values()[copyNumbers.size()];
        if (copyNumbers.size() == 5 && haveBonus) {
            rank = Rank.values()[6];
        }
        if (copyNumbers.size() == 6) {
            rank = Rank.values()[7];
        }
        return rank;
    }

    public long getPrizeSum(HashMap<Rank, Integer> result) {
        long sum = 0;

        for (Rank rank : result.keySet()) {
            sum += rank.getPrize() * result.get(rank);
        }

        return sum;
    }


    public static double calculateRevenue(long prizeSum, int buyAmount) {
        double revenue = (prizeSum / (double) buyAmount) * 100;

        return round(revenue * 10) / 10.0;
    }
}
