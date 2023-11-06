package lotto.service;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.dto.WinningStatisticsDto;

public class WinningStatisticsService {
    private final LottoService lottoService;
    private Map<WinningPolicy, Integer> winningStatistics = new EnumMap<>(WinningPolicy.class);

    public WinningStatisticsService(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public void setWinningStatistics() {
        WinningPolicy[] winningPolicies = WinningPolicy.values();
        for (WinningPolicy winningPolicy : winningPolicies) {
            if (winningPolicy != WinningPolicy.NONE) {
                winningStatistics.put(winningPolicy, 0);
            }
        }

        List<Lotto> lottos = lottoService.getLottos();
        for (Lotto lotto : lottos) {
            int lottoCount = lotto.match(lottoService.getWinningLotto().lotto());
            boolean bonusMatch = lotto.matchBonus(lottoService.getWinningLotto().bonusNumber());
            WinningPolicy winningPolicy = WinningPolicy.of(lottoCount, bonusMatch);
            if (winningPolicy != WinningPolicy.NONE) {
                winningStatistics.put(winningPolicy, winningStatistics.get(winningPolicy) + 1);
            }
        }
    }

    public List<WinningStatisticsDto> getWinningStatistics() {
        return winningStatistics.entrySet().stream()
                .map(entry -> new WinningStatisticsDto(entry.getKey(), entry.getValue()))
                .toList();
    }

    public double getEarningRate(int purchasePrice) {
        return winningStatistics.entrySet().stream()
                .map(entry -> entry.getKey().getAmount() * entry.getValue())
                .collect(Collectors.summingInt(Integer::intValue))
                .doubleValue() / purchasePrice * 100;
    }
}
