package lotto.service;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LottoService {
    private final List<List<Integer>> userNumbers;
    private final List<Integer> numbers;
    private final int bonusNumber;
    private ConcurrentHashMap<List<Integer>, Winning> winningResults;

    public LottoService(List<List<Integer> >userNumbers, List<Integer> numbers, int bonusNumber) {
        this.userNumbers = userNumbers;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
    public ConcurrentHashMap<List<Integer>, Winning> compareLottoNumber() {
        winningResults = countEqualNumber();

        for (Map.Entry<List<Integer>, Winning> entry : winningResults.entrySet()) {
            if(entry.getValue().getEqualCount() == 5) {
                entry.getValue().updateBonus(entry.getKey(), bonusNumber);
            }
        }

        return (ConcurrentHashMap<List<Integer>, Winning>) winningResults.entrySet().stream()
                .filter(winning -> winning.getValue().getEqualCount() >= 3)
                .collect(Collectors.toConcurrentMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    private ConcurrentHashMap<List<Integer>, Winning> countEqualNumber() {
        List<Long> equalCounts = new ArrayList<>();

        for (List<Integer> userNumber : userNumbers) {
            equalCounts.add(userNumber.stream()
                    .filter(number -> numbers.stream().anyMatch(Predicate.isEqual(number)))
                    .count());
        }
        WinningResult winningResult = new WinningResult(userNumbers, equalCounts);

        return winningResult.getWinngResult();
    }
}
