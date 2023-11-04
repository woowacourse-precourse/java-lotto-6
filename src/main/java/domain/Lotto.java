package domain;

import constant.Rank;
import java.util.List;
import java.util.stream.Collectors;
import validator.LottoValidator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        LottoValidator.size(numbers);
        LottoValidator.duplicate(numbers);
        LottoValidator.inRange(numbers);
    }

    // TODO: 추가 기능 구현
    public List<Integer> getNumbers() {
        return numbers;
    }

    public void printNumbers() {
        List<Integer> sortedNumbers = numbers.stream()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(sortedNumbers);
    }

    public Rank getRank(List<Integer> winningNumbers, int bonus) {
        int matchingCount = getMatchingCounts(winningNumbers);
        boolean matchingBonus = getMatchingBonus(bonus);

        return Rank.getRank(matchingCount, matchingBonus);
    }

    private int getMatchingCounts(List<Integer> winningNumbers) {
        int matchingCount = 0;

        for (Integer number : numbers) {
            if (winningNumbers.contains(number)) {
                matchingCount++;
            }
        }
        return matchingCount;
    }

    private boolean getMatchingBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
