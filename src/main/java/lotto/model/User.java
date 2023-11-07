package lotto.model;

import java.util.List;
import java.util.stream.Collectors;

public class User {
    private final List<Integer> winningNumbers;
    private final int bonusNumber;

    public User(List<String> winningNumbers, int bonusNumber) {
        this.winningNumbers = strToInt(winningNumbers);
        this.bonusNumber = bonusNumber;
    }

    private List<Integer> strToInt(List<String> numbers) {
        List<Integer> convertedNumbers;
        convertedNumbers = numbers.stream()
                .map(Integer::parseInt)
                .collect(Collectors.toList());
        return convertedNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
