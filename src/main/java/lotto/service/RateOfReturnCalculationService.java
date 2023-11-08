package lotto.service;

import java.util.Map;
import lotto.domain.WinningStatus;

public interface RateOfReturnCalculationService {
    public double calculateRateOfReturn(long totalPrice, Map<WinningStatus, Integer> winningStatistics);
}
