package lotto.service;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.dto.WinningStatisticsDto;

public class WinningStatisticsService {
    private final LottoService lottoService;
    private final Map<WinningPolicy, Integer> winningStatistics = new EnumMap<>(WinningPolicy.class);

    public WinningStatisticsService(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void setWinningStatistics() {
        initializeWinningStatistics();

        List<Lotto> lottos = lottoService.getLottos();
        lottos.forEach(this::updateWinningStatistics);
    }

    public List<WinningStatisticsDto> getWinningStatistics() {
        return winningStatistics.entrySet().stream()
                .map(entry -> new WinningStatisticsDto(entry.getKey(), entry.getValue()))
                .toList();
    }

    public double getEarningRate(int purchasePrice) {
        int totalWinningAmount = winningStatistics.entrySet().stream()
                .mapToInt(entry -> entry.getKey().getAmount() * entry.getValue())
                .sum();

        return (double) totalWinningAmount / purchasePrice * 100;
    }

    private void initializeWinningStatistics() {
        Arrays.stream(WinningPolicy.values())
                .filter(winningPolicy -> winningPolicy != WinningPolicy.NONE)
                .forEach(winningPolicy -> winningStatistics.put(winningPolicy, 0));
    }

    private void updateWinningStatistics(Lotto lotto) {
        int lottoCount = lotto.match(lottoService.getWinningLotto().lotto());
        boolean bonusMatch = lotto.matchBonus(lottoService.getWinningLotto().bonusNumber());
        WinningPolicy winningPolicy = WinningPolicy.of(lottoCount, bonusMatch);

        if (winningPolicy != WinningPolicy.NONE) {
            winningStatistics.put(winningPolicy, winningStatistics.get(winningPolicy) + 1);
        }
    }
}
