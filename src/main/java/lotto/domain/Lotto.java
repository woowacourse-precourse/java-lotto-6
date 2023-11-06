package lotto.domain;

import lotto.constant.LottoConfig;
import lotto.constant.LottoRank;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplication(numbers);
        this.numbers = duplicateSortedList(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (numbers.size() != LottoConfig.LOTTO_LENGTH) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if(set.size() != numbers.size()) {
            throw new IllegalArgumentException();
        }
    }

    private List<Integer> duplicateSortedList(List<Integer> numbers) {
        List<Integer> list = new ArrayList<>(numbers);
        Collections.sort(list);
        return list;
    }

    public LottoRank calculate(Result result) {
        int winningCount = (int) numbers.stream().filter(result::winningNumbersContain).count();
        int bonus = (int) numbers.stream().filter(result::bonusNumberIs).count();
        return LottoRank.findRank(winningCount, bonus);
    }

    @Override
    public String toString() {
        return numbers.toString();
    }

}
