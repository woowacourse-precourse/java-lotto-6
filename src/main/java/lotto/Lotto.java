package lotto;


import java.util.*;


public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
        Collections.sort(numbers);
    }


    private void validate(List<Integer> numbers) {
        if (numbers == null || numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }

        Set<Integer> uniqueNumbers = new HashSet<>(numbers);
        if (uniqueNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 중복될 수 없습니다.");
        }

        for (int number : numbers) {
            if (number < 1 || number > 45) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
            }
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }

    public int countMatches(List<Integer> winningNumbers) {
        Set<Integer> winningNumbersSet = new HashSet<>(winningNumbers);
        Set<Integer> numbersSet = new HashSet<>(numbers);

        winningNumbersSet.retainAll(numbersSet);
        return winningNumbersSet.size();
    }
}