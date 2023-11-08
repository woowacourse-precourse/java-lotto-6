package lotto.service;

import java.util.List;
import java.util.Map;
import lotto.domain.WinningStatus;

public interface WinningCalculationService {
    Map<WinningStatus, Integer> calculateWinningStatistics(List<Integer> winningNumbers, int bonusNumber);
}
