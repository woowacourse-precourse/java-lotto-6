package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class WinningNumbers {
    private List<Integer> numbers;
    private int bonusNumber;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }

    public Map<Long, Long> isMatching(List<Lotto> lottos) {
        return lottos.stream()
                .map(lotto -> {
                    List<Integer> lottoNumbers = lotto.getNumbers();
                    long matchingNumbers = lottoNumbers.stream()
                            .filter(numbers::contains)
                            .count();
                    if (matchingNumbers == 5 && lottoNumbers.contains(bonusNumber)) {
                        return 7L;
                    }
                    return matchingNumbers;
                })
                .collect(Collectors.groupingBy(count -> count, Collectors.counting()));
    }



}
