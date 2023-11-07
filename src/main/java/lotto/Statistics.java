package lotto;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Statistics {

    private static final double RANK_1 = 2000000000;
    private static final double RANK_2 = 30000000;
    private static final double RANK_3 = 1500000;
    private static final double RANK_4 = 50000;
    private static final double RANK_5 = 5000;
    private static final int SIX_NUMBER_MATCH = 6;
    private static final int FIVE_BONUS_NUMBER_MATCH = 7;
    private static final int FIVE_NUMBER_MATCH = 5;
    private static final int FOUR_NUMBER_MATCH = 4;
    private static final int THREE_NUMBER_MATCH = 3;
    private final List<Lotto> USER_LOTTOS;
    private final Lotto WIN_LOTTO;
    private final int BONUS_NUMBER;
    public Map<Integer, Integer> countWin = new HashMap<>();
    public double profit;

    public Statistics(List<Lotto> userLottos, Lotto winLotto, int bonusNumber) {
        this.USER_LOTTOS = userLottos;
        this.WIN_LOTTO = winLotto;
        this.BONUS_NUMBER = bonusNumber;
        countWin.put(SIX_NUMBER_MATCH, 0);
        countWin.put(FIVE_BONUS_NUMBER_MATCH, 0);
        countWin.put(FIVE_NUMBER_MATCH, 0);
        countWin.put(FOUR_NUMBER_MATCH, 0);
        countWin.put(THREE_NUMBER_MATCH, 0);
        searchMatch();
    }

    public void searchMatch() {
        for (Lotto userLotto : USER_LOTTOS) {
            countWin.replace(SIX_NUMBER_MATCH, countWin.get(SIX_NUMBER_MATCH) + isSixMatch(userLotto.getNumbers()));
            countWin.replace(FIVE_BONUS_NUMBER_MATCH, countWin.get(FIVE_BONUS_NUMBER_MATCH) + isFiveBonusMatch(userLotto.getNumbers()));
            countWin.replace(FIVE_NUMBER_MATCH, countWin.get(FIVE_NUMBER_MATCH) + isFiveMatch(userLotto.getNumbers()));
            countWin.replace(FOUR_NUMBER_MATCH, countWin.get(FOUR_NUMBER_MATCH) + isFourMatch(userLotto.getNumbers()));
            countWin.replace(THREE_NUMBER_MATCH, countWin.get(THREE_NUMBER_MATCH) + isThreeMatch(userLotto.getNumbers()));
        }
    }

    public long countMatch(List<Integer> userLotto) {
        return userLotto.stream().filter(number -> WIN_LOTTO.getNumbers().contains(number)).count();
    }

    public int isSixMatch(List<Integer> userLotto) {
        if (countMatch(userLotto) == SIX_NUMBER_MATCH) {
            profit += RANK_1;
            return 1;
        }
        return 0;
    }

    public int isFiveBonusMatch(List<Integer> userLotto) {
        if (countMatch(userLotto) == FIVE_NUMBER_MATCH && userLotto.contains(BONUS_NUMBER)) {
            profit += RANK_2;
            return 1;
        }
        return 0;
    }

    public int isFiveMatch(List<Integer> userLotto) {
        if (countMatch(userLotto) == FIVE_NUMBER_MATCH && !userLotto.contains(BONUS_NUMBER)) {
            profit += RANK_3;
            return 1;
        }
        return 0;
    }

    public int isFourMatch(List<Integer> userLotto) {
        if (countMatch(userLotto) == FOUR_NUMBER_MATCH) {
            profit += RANK_4;
            return 1;
        }
        return 0;
    }

    public int isThreeMatch(List<Integer> userLotto) {
        if (countMatch(userLotto) == THREE_NUMBER_MATCH) {
            profit += RANK_5;
            return 1;
        }
        return 0;
    }

    public int getSixNumberMatch() {
        return countWin.get(SIX_NUMBER_MATCH);
    }

    public int getFiveBonusNumberMatch() {
        return countWin.get(FIVE_BONUS_NUMBER_MATCH);
    }

    public int getFiveNumberMatch() {
        return countWin.get(FIVE_NUMBER_MATCH);
    }

    public int getFourNumberMatch() {
        return countWin.get(FOUR_NUMBER_MATCH);
    }

    public int getThreeNumberMatch() {
        return countWin.get(THREE_NUMBER_MATCH);
    }

    public double getRateOfReturn(int price) {
        return (profit / (double)price) * 100;
    }
}
