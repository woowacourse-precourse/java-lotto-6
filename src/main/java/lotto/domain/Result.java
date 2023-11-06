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
        int count = 0;
        for (Checker checker : checkers) {
            if (checker.getCount() == FIFTH) {
                count++;
            }
        }
        return count;
    }

    private int getFourth(List<Checker> checkers) {
        int count = 0;
        for (Checker checker : checkers) {
            if (checker.getCount() == FOURTH) {
                count++;
            }
        }
        return count;
    }

    private int getThird(List<Checker> checkers) {
        int count = 0;
        for (Checker checker : checkers) {
            if (checker.getCount() == THIRD) {
                count++;
            }
        }
        return count;
    }

    private int getSecond(List<Checker> checkers) {
        int count = 0;
        for (Checker checker : checkers) {
            if (checker.getCount() == SECOND && checker.isBonus()) {
                count++;
            }
        }
        return count;
    }

    private int getFirst(List<Checker> checkers) {
        int count = 0;
        for (Checker checker : checkers) {
            if (checker.getCount() == FIRST) {
                count++;
            }
        }
        return count;
    }

    public List<Integer> getResults() {
        return results;
    }
}
