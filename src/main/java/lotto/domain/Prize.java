package lotto.domain;

import static lotto.condition.Reward.FIVE;
import static lotto.condition.Reward.FIVE_AND_BONUS;
import static lotto.condition.Reward.FOUR;
import static lotto.condition.Reward.SIX;
import static lotto.condition.Reward.THREE;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.ResultResponse;

public class Prize {
    private final Map<Integer, Integer> prizeResult;

    private Prize(final List<List<Integer>> allLotto, final List<Integer> answerNumbers, final int bonusNumber) {
        this.prizeResult = createPrize(allLotto, answerNumbers, bonusNumber);
    }

    public static Prize create(final List<List<Integer>> allLotto, final List<Integer> answerNumbers, int bonusNumber) {
        return new Prize(allLotto, answerNumbers, bonusNumber);
    }


    public Map<Integer, Integer> createPrize(final List<List<Integer>> allLotto, List<Integer> answerNumbers,
                                             final int bonusNumber) {
        Map<Integer, Integer> result = new LinkedHashMap<>();
        initMap(result);
        for (List<Integer> lottoNumbers : allLotto) {
            int matchingNumbers = countMatchingNumbers(lottoNumbers, answerNumbers);
            boolean hasBonusNumber = hasBonusNumber(lottoNumbers, bonusNumber);
            determinePrize(result, matchingNumbers, hasBonusNumber);
        }
        return result;
    }

    private void initMap(final Map<Integer, Integer> result) {
        result.put(THREE.getNumberOfMatches(), 0);
        result.put(FOUR.getNumberOfMatches(), 0);
        result.put(FIVE.getNumberOfMatches(), 0);
        result.put(FIVE_AND_BONUS.getNumberOfMatches(), 0);
        result.put(SIX.getNumberOfMatches(), 0);
    }

    private int countMatchingNumbers(final List<Integer> lottoNumbers, final List<Integer> answerNumbers) {
        return (int) lottoNumbers.stream().filter(answerNumbers::contains).count();
    }


    private boolean hasBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void determinePrize(Map<Integer, Integer> result, int matchingNumbers, boolean hasBonusNumber) {
        addFifthRank(result, matchingNumbers);
        addFourthRank(result, matchingNumbers);
        addThirdRank(result, matchingNumbers, hasBonusNumber);
        addSecondRank(result, matchingNumbers, hasBonusNumber);
        addFirstRank(result, matchingNumbers);
    }

    private void addFifthRank(Map<Integer, Integer> result, int matchingNumbers) {
        if (matchingNumbers == 3) {
            result.put(THREE.getNumberOfMatches(), result.get(THREE.getNumberOfMatches()) + 1);
        }
    }

    private void addFourthRank(Map<Integer, Integer> result, int matchingNumbers) {
        if (matchingNumbers == 4) {
            result.put(FOUR.getNumberOfMatches(), result.get(FOUR.getNumberOfMatches()) + 1);
        }
    }

    private void addThirdRank(Map<Integer, Integer> result, int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 5 && !hasBonusNumber) {
            result.put(FIVE.getNumberOfMatches(), result.get(FIVE.getNumberOfMatches()) + 1);
        }
    }

    private void addSecondRank(Map<Integer, Integer> result, int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 5 && hasBonusNumber) {
            result.put(FIVE_AND_BONUS.getNumberOfMatches(), result.get(FIVE_AND_BONUS.getNumberOfMatches()) + 1);
        }
    }

    private void addFirstRank(Map<Integer, Integer> result, int matchingNumbers) {
        if (matchingNumbers == 6) {
            result.put(SIX.getNumberOfMatches(), result.get(SIX.getNumberOfMatches()) + 1);
        }
    }

    public ResultResponse generateResultResponse() {
        return new ResultResponse(prizeResult);
    }
}
