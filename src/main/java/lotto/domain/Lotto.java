package lotto.domain;

import java.util.HashSet;
import java.util.List;
import lotto.message.ConsoleMessage;
import lotto.util.LottoNumberGenerator;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        HashSet set = new HashSet(numbers);
        if(set.size()!= numbers.size()){
            throw new IllegalArgumentException(ConsoleMessage.);
        }
    }


}
