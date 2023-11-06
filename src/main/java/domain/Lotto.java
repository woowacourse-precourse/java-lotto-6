package domain;

import java.util.List;
import java.util.regex.Pattern;
import util.ErrorMessage;

public class Lotto {
    public static final Pattern lotto = Pattern.compile("[1-9]|[1-3][0-9]|4[0-5]");
    private final List<Integer> numbers;

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
            throw new IllegalArgumentException(ErrorMessage.LOTTO_COUNT_LIMIT.getErrorMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers){
        if (numbers.size() != numbers.stream().distinct().count()) {
            throw new IllegalArgumentException(ErrorMessage.CANT_DUPLICATE_NUMBER.getErrorMessage());
        }
    }

    private void validateRange(List<Integer> numbers) {
        for (Integer number : numbers) {
            if (!lotto.matcher(Integer.toString(number)).matches()) {
                throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMBER_RANGE.getErrorMessage());
            }
        }
    }


    public static void outputLotto(Lotto lotto) {
        System.out.println(lotto.numbers.toString());
    }

}
