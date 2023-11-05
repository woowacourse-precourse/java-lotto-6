package lotto.domain.lotto_policy;

import java.util.List;

public interface LottoWinningPolicy {
    Integer getWinningPrize(List<Integer> lottoNumbers, List<Integer> winningNumbers);
}
