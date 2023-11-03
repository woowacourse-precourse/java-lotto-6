package lotto;

import java.util.List;

public class LottoRank {
    private int countMatchingNumbers(List<Integer> lottoNumbers, List<Integer> compareNumbers) {
        long count = lottoNumbers.stream()
                .filter(compareNumbers::contains)
                .count();
        return (int) count;
    }
}
