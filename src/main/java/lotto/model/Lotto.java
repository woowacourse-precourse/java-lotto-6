package lotto.model;

import java.util.List;
import java.util.stream.Collectors;
import lotto.validator.ValidateLotto;

public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        ValidateLotto.validateLotto(numbers);
        List<Integer> sortedNumber = sortLottoNumbers(numbers);
        this.numbers = sortedNumber;
    }

    private List<Integer> sortLottoNumbers(List<Integer> numbers){
        return numbers.stream()
                .sorted()
                .collect(Collectors.toList());
    }


    public boolean hasBonusNumber(int bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public List<Integer> getLotto(){
        return numbers;
    }
}
