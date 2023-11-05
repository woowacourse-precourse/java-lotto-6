package lotto;

import java.util.List;
import java.util.regex.Pattern;

public class Lotto {
    private final List<Integer> numbers;
    private final Pattern lottoPattern = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        validateRange(numbers);
    }

    private void validateSize(List<Integer> numbers){
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException();
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!lottoPattern.matcher(Integer.toString(number)).matches()) {
                throw new IllegalArgumentException();
            }
        }

    }

}
