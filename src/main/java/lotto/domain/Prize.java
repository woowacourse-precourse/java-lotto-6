package lotto.domain;

import static lotto.domain.Rank.FIFTH;
import static lotto.domain.Rank.FIRST;
import static lotto.domain.Rank.FOURTH;
import static lotto.domain.Rank.SECOND;
import static lotto.domain.Rank.THIRD;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.dto.ResultResponse;

public class Prize {
    private final Map<String, Integer> prizeResult;

    private Prize(final List<Integer> answerNumbers, final List<List<Integer>> allLotto, final int bonusNumber) {
        this.prizeResult = createPrize(answerNumbers, allLotto, bonusNumber);
    }

    public static Prize create(List<Integer> answerNumbers, List<List<Integer>> allLotto, int bonusNumber) {
        return new Prize(answerNumbers, allLotto, bonusNumber);
    }


    public Map<String, Integer> createPrize(List<Integer> answerNumbers, List<List<Integer>> allLotto,
                                            int bonusNumber) {
        Map<String, Integer> result = new HashMap<>();
        initMap(result);
        for (List<Integer> lottoNumbers : allLotto) {
            int matchingNumbers = countMatchingNumbers(answerNumbers, lottoNumbers);
            boolean hasBonusNumber = hasBonusNumber(lottoNumbers, bonusNumber);
            determinePrize(result, matchingNumbers, hasBonusNumber);
        }
        return result;
    }

    private void initMap(Map<String, Integer> result) {
        result.put(FIFTH.getNumberOfMatches(), 0);
        result.put(FOURTH.getNumberOfMatches(), 0);
        result.put(THIRD.getNumberOfMatches(), 0);
        result.put(SECOND.getNumberOfMatches(), 0);
        result.put(FIRST.getNumberOfMatches(), 0);
    }

    private int countMatchingNumbers(List<Integer> answerNumbers, List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(answerNumbers::contains).count();
    }


    private boolean hasBonusNumber(List<Integer> lottoNumbers, int bonusNumber) {
        return lottoNumbers.contains(bonusNumber);
    }

    private void determinePrize(Map<String, Integer> result, int matchingNumbers, boolean hasBonusNumber) {
        addFifthRank(result, matchingNumbers);
        addFourthRank(result, matchingNumbers);
        addThirdRank(result, matchingNumbers, hasBonusNumber);
        addSecondRank(result, matchingNumbers, hasBonusNumber);
        addFirstRank(result, matchingNumbers);
    }

    private void addFifthRank(Map<String, Integer> result, int matchingNumbers) {
        if (matchingNumbers == 3) {
            result.put(FIFTH.getNumberOfMatches(), result.get(FIFTH.getNumberOfMatches()) + 1);
        }
    }

    private void addFourthRank(Map<String, Integer> result, int matchingNumbers) {
        if (matchingNumbers == 4) {
            result.put(FOURTH.getNumberOfMatches(), result.get(FOURTH.getNumberOfMatches()) + 1);
        }
    }

    private void addThirdRank(Map<String, Integer> result, int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 5 && !hasBonusNumber) {
            result.put(THIRD.getNumberOfMatches(), result.get(THIRD.getNumberOfMatches()) + 1);
        }
    }

    private void addSecondRank(Map<String, Integer> result, int matchingNumbers, boolean hasBonusNumber) {
        if (matchingNumbers == 5 && hasBonusNumber) {
            result.put(SECOND.getNumberOfMatches(), result.get(SECOND.getNumberOfMatches()) + 1);
        }
    }

    private void addFirstRank(Map<String, Integer> result, int matchingNumbers) {
        if (matchingNumbers == 6) {
            result.put(FIRST.getNumberOfMatches(), result.get(FIRST.getNumberOfMatches()) + 1);
        }
    }

    public ResultResponse generateResultResponse() {
        return new ResultResponse(prizeResult);
    }
}
