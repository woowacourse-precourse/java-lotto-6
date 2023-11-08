package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

import lotto.domain.Lotto;
import lotto.domain.WinningStatus;
import lotto.repository.LottoRepository;

public class WinningCalculationServiceImpl implements WinningCalculationService {
    private final LottoRepository lottoRepository;

    public WinningCalculationServiceImpl(LottoRepository lottoRepository) {
        this.lottoRepository = lottoRepository;
    }

    @Override
    public Map<WinningStatus, Integer> calculateWinningStatistics(List<Integer> winningNumbers, int bonusNumber) {
        Map<WinningStatus, Integer> statistics = initializeStatistics();

        List<Integer> resultNumbers = new ArrayList<>(winningNumbers);
        List<Lotto> lottoList = lottoRepository.getLottoList();

        for (Lotto lotto : lottoList) {
            int matchingCount = calculateMatchingCount(resultNumbers, lotto.getNumbers());
            boolean isBonusNumberMatch = lotto.getNumbers().contains(bonusNumber);
            updateStatistics(statistics, matchingCount, isBonusNumberMatch);
        }

        return statistics;
    }

    private Map<WinningStatus, Integer> initializeStatistics() {
        Map<WinningStatus, Integer> statistics = new EnumMap<>(WinningStatus.class);
        for (WinningStatus status : WinningStatus.values()) {
            statistics.put(status, 0);
        }
        return statistics;
    }

    private int calculateMatchingCount(List<Integer> resultNumbers, List<Integer> lottoNumbers) {
        return (int) resultNumbers.stream()
                .filter(lottoNumbers::contains)
                .count();
    }

    private void updateStatistics(Map<WinningStatus, Integer> statistics, int matchingCount,
                                  boolean isBonusNumberMatch) {
        for (WinningStatus status : WinningStatus.values()) {
            updateSingleStatistic(statistics, status, matchingCount, isBonusNumberMatch);
        }
    }

    private void updateSingleStatistic(Map<WinningStatus, Integer> statistics, WinningStatus status, int matchingCount,
                                       boolean isBonusNumberMatch) {
        if (matchingCount != status.getMatchingCount()) {
            return;
        }

        if (isBonusNumberMatch && status == WinningStatus.SECOND) {
            statistics.put(status, statistics.get(status) + 1);
        } else if (!isBonusNumberMatch && status != WinningStatus.SECOND) {
            statistics.put(status, statistics.get(status) + 1);
        }
    }
}
