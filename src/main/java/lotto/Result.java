package lotto;

import java.util.List;

public class Result {
    private final List<Integer> countLotto;
    private final List<Boolean> countBonusLotto;

    public Result(List<Integer> countLotto, List<Boolean> countBonusLotto) {
        this.countLotto = countLotto;
        this.countBonusLotto = countBonusLotto;
    }

    public void printResult() {

    }
}
