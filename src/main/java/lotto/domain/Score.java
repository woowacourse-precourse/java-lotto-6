package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    Map<Result, Integer> score = new HashMap<>();


    private Result calculate(Lotto lotto, WinningNumber winningNumber) {
        List<Integer> numbers = lotto.getNumbers();
        List<Integer> winningLottoNumbers = winningNumber.getLottoNumbers();
        int bonusNumber = winningNumber.getBonusNumber();
        int matchCount = 0;
        for(int number : numbers) {
            if(winningLottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        boolean isBonusMatched = numbers.contains(bonusNumber);
        return Result.find(matchCount, isBonusMatched);
    }
}
