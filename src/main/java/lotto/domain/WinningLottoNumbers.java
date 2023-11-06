package lotto.domain;

import lotto.validator.system.SystemValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningLottoNumbers {
    private List<Integer> numbers;

    public WinningLottoNumbers(String numbers){
        changeToList(numbers);
        SystemValidator.winningNumbersValidator(this.numbers);
    }

    public List<Integer> getNumbers() {
        if(numbers.isEmpty()){
            throw new IllegalArgumentException();
        }
        return numbers;
    }

    private void changeToList(String numbers){
        this.numbers = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }
}
