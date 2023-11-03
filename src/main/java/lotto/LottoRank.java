package lotto;

import java.util.List;

public class LottoRank {


    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> compareNumbers) {
        long count = lottoNumbers.stream()
                .filter(compareNumbers::contains)
                .count();
        return (int) count;
    }

    private boolean isHasNum(List<Integer> compareNumbers, int bonusNum) {
        boolean hasNum = compareNumbers.stream().anyMatch(n -> n == bonusNum);
        return hasNum;
    }
}
