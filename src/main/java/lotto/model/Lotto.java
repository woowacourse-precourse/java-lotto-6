package lotto.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.validation.ModelValidation;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(final List<Integer> numbers) {
        validate(numbers);
        List<Integer> mutableNumbers = new ArrayList<>(numbers);
        Collections.sort(mutableNumbers);
        this.numbers = mutableNumbers;
    }

    private void validate(List<Integer> numbers) {
        ModelValidation.validateSize(numbers);
        ModelValidation.validateDuplicate(numbers);
        ModelValidation.validateRange(numbers);
    }

    public int countCorrectNumbers(Lotto lotto) {
        int count = 0;
        for (Integer winingNumber : numbers) {
            if (lotto.containNumber(winingNumber)) {
                count++;
            }
        }
        return count;
    }

    public boolean containNumber(int number) {
        return numbers.contains(number);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }
}
