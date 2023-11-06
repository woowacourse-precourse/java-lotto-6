package lotto;

import java.util.List;

public class ComparisonMachine {
    List<List<Integer>> allLottoCollection;
    List<Integer> winningNumbers;
    int bounsNumber;
    public ComparisonMachine(List<List<Integer>> allLottoCollection, List<Integer> winningNumbers, int bounsNumber) {
        this.allLottoCollection = allLottoCollection;
        this.winningNumbers = winningNumbers;
        this.bounsNumber = bounsNumber;
    }


}
