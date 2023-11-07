package lotto.model.lottoResultChecker;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;



public class Lotto {
    private final List<Integer> numbers;

    public Lotto(String input) {
        this.numbers = parseAndValidate(input);
    }


    private List<Integer> parseAndValidate(String input) {
        ensureNotEmpty(input);
        String[] numberStrings = splitInput(input);
        List<Integer> parsedNumbers = parseNumbers(numberStrings);
        ensureCorrectCount(parsedNumbers);
        ensureValidRange(parsedNumbers);
        ensureNoDuplicates(parsedNumbers);
        return parsedNumbers;
    }


    private void ensureNotEmpty(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 번호를 입력해야 합니다.");
        }
    }

    private String[] splitInput(String input) {
        return input.split(",");
    }


    private List<Integer> parseNumbers(String[] numberStrings) {
        try {
            return Arrays.stream(numberStrings)
                    .map(String::trim)
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }


    private List<Integer> parseNumbers(String input) {
        return parseNumbers(splitInput(input));
    }


    private void ensureCorrectCount(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 번호는 6개여야 합니다.");
        }
    }


    private void ensureValidRange(List<Integer> numbers) {
        if (numbers.stream().anyMatch(number -> number < 1 || number > 45)) {
            throw new IllegalArgumentException("[ERROR] 번호는 1에서 45 사이여야 합니다.");
        }
    }

    private void ensureNoDuplicates(List<Integer> numbers) {
        Set<Integer> numberSet = new HashSet<>(numbers);
        if (numberSet.size() != numbers.size()) {
            throw new IllegalArgumentException("[ERROR] 번호는 중복될 수 없습니다.");
        }
    }

    public List<Integer> getNumbers() {
        return new ArrayList<>(numbers);
    }
}
