package lotto.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Winning {
    private final List<Integer> numbers;

    public Winning(String inputNumbers) {
        List<Integer> nubmers = convertToList(inputNumbers);
        validateSize(nubmers);
        validateRange(nubmers);
        validateDuplicate(nubmers);
        this.numbers = nubmers;

    }

    private List<Integer> convertToList(String inputNumbers) {
        return Arrays.stream(inputNumbers.split(","))
                .map(num -> convertToInt(num))
                .collect(Collectors.toList());

    }

    private void validateRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(num -> num < 1 || num > 45)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1이상 45이하 숫자여야 합니다.");
        }
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (numbers.stream().distinct().count() != 6) {
            throw new IllegalArgumentException("[ERROR] 중복된 번호가 존재합니다.");
        }
    }

    private int convertToInt(String num) {
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자여야 합니다.");
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
