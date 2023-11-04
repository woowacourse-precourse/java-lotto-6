package lotto.model;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import lotto.model.dto.WinningNumDTO;

public class Lotto {
    private static final String START_TAG = "[";
    private static final String SEPARATOR = ", ";
    private static final String END_TAG = "]";
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
        if (isDuplicate(numbers)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean isDuplicate(List<Integer> numbers) {
        return numbers.stream().distinct().count() < numbers.size();
    }

    // TODO: 추가 기능 구현
    public String getSelectedNumbers() {
        StringBuilder sb = new StringBuilder();
        sb.append(START_TAG);
        List<String> nums_str = numbers.stream().map(String::valueOf).toList();
        sb.append(String.join(SEPARATOR, nums_str));
        sb.append(END_TAG);
        return sb.toString();
    }

    public Ranking checkResult(WinningNumDTO winningNumDTO) {
        int correct = getNumOfCorrect(winningNumDTO.getWinningNums());
        return Ranking.of(correct, isBonus(winningNumDTO.getBonus()));
    }

    private int getNumOfCorrect(List<Integer> winningNums) {
        return (int) winningNums.stream().filter(num -> numbers.contains(num)).count();
    }

    private boolean isBonus(int bonus) {
        return numbers.contains(bonus);
    }
}
