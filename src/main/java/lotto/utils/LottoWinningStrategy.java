package lotto.utils;

import lotto.domain.Result;

import java.util.List;

public interface LottoWinningStrategy {
    Result determineResult(List<Integer> lottoNumbers, List<Integer> winningNumbers, int bonusBall);
}
