package lotto.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> winningNumbers;
    WinningNumbers(List<Integer> winningNumbers){
        validateSize(winningNumbers);
        this.winningNumbers = winningNumbers;   
    }

    private void validateSize(List<Integer> winningNumbers) {
    }

    public static WinningNumbers from(String numbers){
        List<Integer> number = Arrays.stream(numbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        return new WinningNumbers(number);
    }

    public boolean add(int number){
        return this.winningNumbers.add(number);
    }
}
