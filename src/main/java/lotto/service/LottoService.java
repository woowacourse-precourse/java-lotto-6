package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.dto.WinningStatisticsDto;

public interface LottoService {
    List<Lotto> issueNewLotto(int count) throws IllegalArgumentException;

    WinningStatisticsDto getWinningStatistics(List<Lotto> lottos, Lotto winningLotto, int bonusNumber);
}
