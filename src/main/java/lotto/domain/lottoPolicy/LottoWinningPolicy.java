package lotto.domain.lottoPolicy;

import java.util.List;

public interface LottoWinningPolicy {
    Integer getWinningPrize(List<Integer> lottoNumbers, List<Integer> winningNumbers);
}
