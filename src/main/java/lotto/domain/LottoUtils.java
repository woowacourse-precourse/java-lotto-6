package lotto.domain;

import java.util.List;

public class LottoUtils {

    public static int getMatchCount(List<Integer> winningNumbers, List<Integer> lottoNumbers) {
        int matchCount = 0;
        for (int number : winningNumbers) {
            if (lottoNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }
}
