package lotto;

import java.util.List;

public class Statistics {

    private final List<List<Integer>> lottoNumbers;
    private final List<Integer> winningNumbers;
    private final Integer bonus;

    public Statistics(List<List<Integer>> lottoNumbers, List<Integer> winningNumbers, Integer bonus) {
        this.lottoNumbers = lottoNumbers;
        this.winningNumbers = winningNumbers;
        this.bonus = bonus;
    }


}
