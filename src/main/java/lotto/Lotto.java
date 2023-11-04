package lotto;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    // TODO: 추가 기능 구현
    private String[] splitInputByComma(String input) {
        return input.split(",");
    }

    private List<Integer> convertToIntegerList(String[] splittedLottoNumber) {
        return Arrays.stream(splittedLottoNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    public List<Integer> parseCommaSeparatedUserInput(String userInput) {
        String[] splittedLottoNumber = splitInputByComma(userInput);
        return convertToIntegerList(splittedLottoNumber);
    }


}
