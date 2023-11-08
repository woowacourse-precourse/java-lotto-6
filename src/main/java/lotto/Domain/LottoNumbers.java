package lotto.Domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.Exception.LottoNumberErrorMessage;

public class LottoNumbers {
    private final int MINIMUM_VALUE = 1;
    private final int MAXIMUM_VALUE = 45;
    private final int COUNT_NUMBER = 6;

    private List<Integer> numbers;

    public LottoNumbers() {
        this.numbers = generateRandomNumbers();
        validate(numbers);
    }

    private void validate(List<Integer> numbers) {
        for (int i = 1; i < numbers.size(); i++) {
            if (numbers.get(i) <= numbers.get(i - 1)) {
                throw new IllegalArgumentException(LottoNumberErrorMessage.IS_NOT_ASCENDING_NUMBER.getMessage());
            }
        }
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private List<Integer> generateRandomNumbers() {
        List<Integer> generatedNumbers = Randoms.pickUniqueNumbersInRange(MINIMUM_VALUE, MAXIMUM_VALUE, COUNT_NUMBER);
        return generatedNumbers;
    }
}
