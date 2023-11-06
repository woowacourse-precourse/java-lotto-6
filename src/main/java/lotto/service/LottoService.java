package lotto.service;

import lotto.model.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Predicate;

public class LottoService {
    private final List<List<Integer>> userNumbers;
    private final List<Integer> numbers;
    private final int bonusNumber;
    private ConcurrentHashMap<List<Integer>, Winning> winningResult;

    public LottoService(List<List<Integer> >userNumbers, List<Integer> numbers, int bonusNumber) {
        this.userNumbers = userNumbers;
        this.numbers = numbers;
        this.bonusNumber = bonusNumber;
    }
    public ConcurrentHashMap<List<Integer>, Winning> compareLottoNumber() {
        winningResult = countEqualNumber();

        for (Map.Entry<List<Integer>, Winning> entrySet : winningResult.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getEqualCount() + "," + entrySet.getValue().getBonus());
        }

        for (Map.Entry<List<Integer>, Winning> entry : winningResult.entrySet()) {
            if(entry.getValue().getEqualCount() == 5) {
                entry.getValue().updateBonus(entry.getKey(), bonusNumber);
            }
        }

        for (Map.Entry<List<Integer>, Winning> entrySet : winningResult.entrySet()) {
            System.out.println(entrySet.getKey() + " : " + entrySet.getValue().getEqualCount() + "," + entrySet.getValue().getBonus());
        }

        return winningResult;
    }

    private ConcurrentHashMap<List<Integer>, Winning> countEqualNumber() {
        List<Long> equalCounts = new ArrayList<>();

        for (List<Integer> userNumber : userNumbers) {
            equalCounts.add(userNumber.stream().filter(number -> numbers.stream()
                            .anyMatch(Predicate.isEqual(number)))
                    .count());
        }
        WinningResult winningResult = new WinningResult(userNumbers, equalCounts);

        return winningResult.getWinngResult();
    }
}
