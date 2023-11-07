package lotto.domain;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Score {
    private final Map<Result, Integer> score;
    public Score(WinningNumber winningNumber , Lotties lotties) {
        this.score = calculate(winningNumber,lotties);
    }

    public static Map<Result,Integer> calculate(WinningNumber winningNumber, Lotties lotties) {
        Map<Result,Integer> score = new HashMap<>();
        for (Lotto lotto : lotties.getLotties()) {
            Result result = calculate(winningNumber, lotto);
            int resultCnt = score.getOrDefault(result, 0);
            score.put(result, resultCnt + 1);
        }
        return score;
    }
    private static Result calculate(WinningNumber winningNumber, Lotto lotto ) {
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
