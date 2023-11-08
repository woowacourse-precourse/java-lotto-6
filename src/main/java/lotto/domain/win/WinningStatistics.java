package lotto.domain.win;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLottoNumbers;
import lotto.dto.LottoNumberMatchDTO;
import lotto.dto.WinningStatisticDTO;

public class WinningStatistics {

    Map<WinState, Integer> countPerWinStates = new EnumMap<>(WinState.class);

    public WinningStatistics(WinningLottoNumbers winningLottoNumbers, List<Lotto> lotteries) {
        List<LottoNumberMatchDTO> lottoNumberMatchDTOs = getWinStates(winningLottoNumbers, lotteries);
        lottoNumberMatchDTOs.stream()
                .map(WinState::from)
                .forEach(this::addWinStateCount);
    }

    private List<LottoNumberMatchDTO> getWinStates(WinningLottoNumbers winningLottoNumbers, List<Lotto> lotteries) {
        return lotteries.stream()
                .map(winningLottoNumbers::getMatchDTO)
                .toList();
    }

    private void addWinStateCount(Optional<WinState> winState) {
        if (winState.isEmpty()) {
            return;
        }
        int currentCount = countPerWinStates.getOrDefault(winState.get(), 0);
        int addedCount = currentCount + 1;
        countPerWinStates.put(winState.get(), addedCount);
    }

    public List<WinningStatisticDTO> getWinningStatisticsDTOs() {
        return Arrays.stream(WinState.values())
                .map(winState -> {
                    int winningCount = countPerWinStates.getOrDefault(winState, 0);
                    return winState.getWinStateInformation(winningCount);
                })
                .toList();
    }

}
