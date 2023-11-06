package lotto.domain;

import lotto.validator.system.SystemValidator;
import lotto.validator.system.WinningCombinationValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private final List<Integer> numbers;

    public WinningLottoNumbers(String numbers){
        this.numbers = changeToList(numbers);
        WinningCombinationValidator.validateWinningNumbers(this.numbers);
    }

    public List<Integer> getNumbers() {
        if(numbers.isEmpty()){
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private List<Integer> changeToList(String numbers){
        return Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
