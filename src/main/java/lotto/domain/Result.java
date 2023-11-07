package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.*;

public class Result {
    List<Integer> results = new ArrayList<>();

    public Result(List<Checker> checkers) {
        make(checkers);
    }

    private void make(List<Checker> checkers) {
        List<Integer> results = new ArrayList<>();
        results.add(getFifth(checkers));
        results.add(getFourth(checkers));
        results.add(getThird(checkers));
        results.add(getSecond(checkers));
        results.add(getFirst(checkers));
        this.results = results;
    }

    private int getFifth(List<Checker> checkers) {
        int count = ZERO.getConstant();
        for (Checker checker : checkers) {
            if (checker.getCount() == FIFTH.getConstant()) {
                count++;
            }
        }
        return count;
    }

    private int getFourth(List<Checker> checkers) {
        int count = ZERO.getConstant();
        for (Checker checker : checkers) {
            if (checker.getCount() == FOURTH.getConstant()) {
                count++;
            }
        }
        return count;
    }

    private int getThird(List<Checker> checkers) {
        int count = ZERO.getConstant();
        for (Checker checker : checkers) {
            if (checker.getCount() == THIRD.getConstant()) {
                count++;
            }
        }
        return count;
    }

    private int getSecond(List<Checker> checkers) {
        int count = ZERO.getConstant();
        for (Checker checker : checkers) {
            if (checker.getCount() == SECOND.getConstant() && checker.isBonus()) {
                count++;
            }
        }
        return count;
    }

    private int getFirst(List<Checker> checkers) {
        int count = ZERO.getConstant();
        for (Checker checker : checkers) {
            if (checker.getCount() == FIRST.getConstant()) {
                count++;
            }
        }
        return count;
    }

    public double getEarningRate(int amount) {
        double earningRate = (double) (getSumOfPrize(results) * PERCENTAGE.getConstant()) / amount * ROUND_OFF_TO_THE_NEAREST_TENTH.getConstant();
        return (double) Math.round(earningRate) / ROUND_OFF_TO_THE_NEAREST_TENTH.getConstant();
    }

    private long getSumOfPrize(List<Integer> results) {
        long sum = ZERO.getConstant();
        for (int i = FIFTH_INDEX.getConstant(); i <= FIRST_INDEX.getConstant(); i++) {
            if (i == FIFTH_INDEX.getConstant()) {
                sum += (long) results.get(i) * FIFTH_PRIZE_INTEGER.getConstant();
                continue;
            }
            if (i == FOURTH_INDEX.getConstant()) {
                sum += (long) results.get(i) * FOURTH_PRIZE_INTEGER.getConstant();
                continue;
            }
            if (i == THIRD_INDEX.getConstant()) {
                sum += (long) results.get(i) * THIRD_PRIZE_INTEGER.getConstant();
                continue;
            }
            if (i == SECOND_INDEX.getConstant()) {
                sum += (long) results.get(i) * SECOND_PRIZE_INTEGER.getConstant();
                continue;
            }
            sum += (long) results.get(i) * FIRST_PRIZE_LONG.getConstant();
        }
        return sum;
    }

    public List<Integer> getResults() {
        return results;
    }
}
