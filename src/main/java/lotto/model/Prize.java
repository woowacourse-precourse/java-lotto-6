package lotto.model;

import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Prize {
    private final Map<Rank, Integer> prize = new EnumMap<>(Rank.class);

    private long totalMoney;

    private double profit;

    public void initPrize() {
        for (Rank rank : Rank.values()) {
            prize.put(rank, 0);
        }
    }

    public void compareAnswerAndLotto(Answer answer, LottoGame lotto) {
        List<Lotto> lottoGames = lotto.getLottoGames();
        List<Integer> answerNum = answer.getAnswerNumber();
        int bonusNum = answer.getBonusNumber();
        int sameNumCount;
        boolean isBonus;

        for (int i = 0; i < lotto.getLottoNumber(); i++) {
            Lotto targetLotto = lottoGames.get(i);
            List<Integer> lottoNum = targetLotto.getLottoNumber();
            sameNumCount = numberOfSameNumber(answerNum, lottoNum);
            isBonus = isBonus(lottoNum, bonusNum);
            saveResult(sameNumCount, isBonus);
        }
    }

    private int numberOfSameNumber(List<Integer> answer, List<Integer> lotto) {

        int count = 0;

        for (int i = 0; i < lotto.size(); i++) {
            if (lotto.contains(answer.get(i))) {
                count++;
            }
        }
        return count;
    }

    private boolean isBonus(List<Integer> lottoNum, int bonus) {
        for (int i = 0; i < lottoNum.size(); i++) {
            if (lottoNum.contains(bonus)) {
                return true;
            }
        }
        return false;
    }

    private void saveResult(int sameNumCount, boolean isBonus) {
        Rank rank = judgeRank(sameNumCount, isBonus);
        prize.put(rank, prize.get(rank) + 1);
    }

    public Map<Rank, Integer> getPrizeResult() {
        return this.prize;
    }

    public void calculateTotalPrizeMoney() {
        Set<Rank> keySet = prize.keySet();
        for (Rank key : keySet) {
            long lottoPrize = key.getPrize();
            int lottoNum = prize.get(key);

            totalMoney += calculatePrizeMoney(lottoNum, lottoPrize);
        }
    }

    public void calculateProfit(int money) {
        profit = totalMoney * 100 / (double) money;
    }

    public double getProfit() {
        return this.profit;
    }

    public long getTotalPrizeMoney() {
        return this.totalMoney;
    }

    private long calculatePrizeMoney(int lottoNum, long lottoPrize) {
        return lottoNum * lottoPrize;
    }

    private Rank judgeRank(int sameNumCount, boolean isBonus) {
        if (sameNumCount < 3) {
            return noMoneyResult(sameNumCount);
        }
        if (sameNumCount == 5 && isBonus) {
            return Rank.SECOND;
        }
        return MoneyResult(sameNumCount);
    }

    private Rank noMoneyResult(int count) {
        if (count == 0) {
            return Rank.NO_RANK_ZERO;
        }
        if (count == 1) {
            return Rank.NO_RANK_ONE;
        }
        return Rank.NO_RANK_TWO;
    }

    private Rank MoneyResult(int count) {
        if (count == 3) {
            return Rank.FIFTH;
        }
        if (count == 4) {
            return Rank.FOURTH;
        }
        if (count == 5) {
            return Rank.THIRD;
        }
        return Rank.FIRST;
    }
}

