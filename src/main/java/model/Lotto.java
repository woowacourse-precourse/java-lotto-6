package model;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        duplicateCheck(numbers);
        sortLotto(numbers);
        this.numbers = numbers;
    }

    public int checkMatch(List<Integer> prizeNumber) {
        int count = 0;
        for (int number : prizeNumber) {
            if (numbers.contains(number)) {
                count++;
            }
        }
        return count;
    }

    public boolean checkBonus(int bounsNumber) {
        return numbers.contains(bounsNumber);
    }

    public static void validate(List<Integer> numbers) {
        if (numbers.size() != LottoInit.LOTTO_SIZE.getInitial()) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_ORDER_COUNT.getMessage());
        }
    }

    public static void duplicateCheck(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.REDUNDANT_NUMBER.getMessage());
        }
    }

    public void printLotto() {
        System.out.println(numbers);
    }

    void sortLotto(List<Integer> numbers) {

        numbers.sort(Comparator.naturalOrder());
    }
}
