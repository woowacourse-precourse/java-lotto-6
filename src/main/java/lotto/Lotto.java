package lotto;

import java.util.*;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        List<Integer> list = new ArrayList<>(numbers);
        list.sort(Comparator.naturalOrder());
        System.out.println(list);
        this.numbers = list;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    public Integer getRanking(List<Integer> winningNumber) {
        Integer ranking = 8;
        for (Integer number: numbers) {
            if (winningNumber.contains(number)) {
                ranking -= 1;
                continue;
            }
        }
        return ranking;
    }

    public boolean matchBonusNumber(Integer bonusNumber) {
        if (numbers.contains(bonusNumber)) {
            return true;
        }
        return false;
    }
}
