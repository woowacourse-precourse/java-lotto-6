package lotto.domain;


import java.util.Arrays;
import java.util.List;

import static lotto.constant.Constant.RANK_MONEY;

public class Judgement {
    private static final int MIN_WINNING_NUMBER = 3;
    private static final int DEFAULT_COUNT = 0;

    public void checkLottoNumber(Lottos lottos, WinningLotto winningLotto) {
        for (Lotto compare_lotto : lottos.getLottos()) {
            int count = DEFAULT_COUNT;
            count = checkWinningNumberCount(compare_lotto.getNumbers(), winningLotto.getWinning_number());
            checkAddLottoCount(lottos, count);
        }
    }

    private int checkWinningNumberCount(List<Integer> compare_lotto, List<Integer> winning_lotto) {
        int count = DEFAULT_COUNT;
        for (int i = 0; i < compare_lotto.size(); i++) {
            count += compareNumber(compare_lotto.get(i), winning_lotto);
            count = checkFirstRank(i, count);
        }
        return count;
    }

    private int checkFirstRank(int state, int count) {
        if (state == 5 && count == 6) {
            count++;
        }
        return count;
    }

    private int compareNumber(int number, List<Integer> winning_lotto) {
        int count = DEFAULT_COUNT;
        if (winning_lotto.contains(number)) {
            count++;
        }
        return count;
    }

    private void checkAddLottoCount(Lottos lottos, int count) {
        if (count >= MIN_WINNING_NUMBER) {
            lottos.addLottoRank(count);
        }
    }

    public List<Integer> judgeAllLottoRank(Lottos lottos) {
        List<Integer> counts = lottos.getWinningCounts();
        List<Integer> rank = Arrays.asList(0, 0, 0, 0, 0);
        for (int count : counts) {
            judgeLottoRank(rank, count);
        }
        return rank;
    }

    private void judgeLottoRank(List<Integer> rank, int count) {
        if (count > 6) {
            rank.set(4, rank.get(4) + 1);
        }
        if (count == 6) {
            rank.set(3, rank.get(3) + 1);
        }
        if (count == 5) {
            rank.set(2, rank.get(2) + 1);
        }
        if (count == 4) {
            rank.set(1, rank.get(1) + 1);
        }
        if (count == 3) {
            rank.set(0, rank.get(0) + 1);
        }
    }

    public float calculateEarningRate(List<Integer> ranks, Money money) {
        float earningRate = 0;
        for (int i = 0; i < 5; i++) {
            earningRate += RANK_MONEY[i] * ranks.get(i);
        }
        earningRate = earningRate / money.getMoney() * 100;
        return earningRate;
    }
}
