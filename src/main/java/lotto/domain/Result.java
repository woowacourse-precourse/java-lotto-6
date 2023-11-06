package lotto.domain;

import java.util.ArrayList;
import java.util.List;

import static lotto.constant.LottoConstant.*;
import static lotto.constant.LottoMessage.*;

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
        int count = ZERO;
        for (Checker checker : checkers) {
            if (checker.getCount() == FIFTH) {
                count++;
            }
        }
        return count;
    }

    private int getFourth(List<Checker> checkers) {
        int count = ZERO;
        for (Checker checker : checkers) {
            if (checker.getCount() == FOURTH) {
                count++;
            }
        }
        return count;
    }

    private int getThird(List<Checker> checkers) {
        int count = ZERO;
        for (Checker checker : checkers) {
            if (checker.getCount() == THIRD) {
                count++;
            }
        }
        return count;
    }

    private int getSecond(List<Checker> checkers) {
        int count = ZERO;
        for (Checker checker : checkers) {
            if (checker.getCount() == SECOND && checker.isBonus()) {
                count++;
            }
        }
        return count;
    }

    private int getFirst(List<Checker> checkers) {
        int count = ZERO;
        for (Checker checker : checkers) {
            if (checker.getCount() == FIRST) {
                count++;
            }
        }
        return count;
    }

    public double getEarningRate(int amount) {
        double earningRate = (double) (getSumOfPrize(results) * 100) / amount * 10;
        return (double) Math.round(earningRate) / 10;
    }

    private long getSumOfPrize(List<Integer> results) {
        long sum = ZERO;
        for (int i = FIFTH_INDEX; i <= FIRST_INDEX; i++) {
            if (i == FIFTH_INDEX) {
                sum += (long) results.get(i) * FIFTH_PRIZE_INTEGER;
                continue;
            }
            if (i == FOURTH_INDEX) {
                sum += results.get(i) * FOURTH_PRIZE_INTEGER;
                continue;
            }
            if (i == THIRD_INDEX) {
                sum += results.get(i) * THIRD_PRIZE_INTEGER;
                continue;
            }
            if (i == SECOND_INDEX) {
                sum += results.get(i) * SECOND_PRIZE_INTEGER;
                continue;
            }
            sum += results.get(i) * FIRST_PRIZE_LONG;
        }
        return sum;
    }

    public List<Integer> getResults() {
        return results;
    }
}
