package lotto.model;

import java.util.List;

public class LottoResult {

    private int matchResult(List<Integer> lottoNumbers, List<Integer> winningNumbers) {
        int match = 0;
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                match++;
            }
        }
        return match;
    }


}
