package lotto.domain.win;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.WinningLottoNumbers;
import lotto.dto.LottoNumberMatchDTO;
import lotto.dto.WinStateInformationDTO;

public class WinStatesCounter {

    Map<WinState, Integer> countPerWinStates = new EnumMap<>(WinState.class);

    public WinStatesCounter(WinningLottoNumbers winningLottoNumbers, List<Lotto> lotteries) {
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

    private void addWinStateCount(WinState winState) {
        int currentCount = countPerWinStates.getOrDefault(winState, 0);
        int addedCount = currentCount + 1;
        countPerWinStates.put(winState, addedCount);
    }

    public List<WinStateInformationDTO> getWinStateInformationDTOs() {
        return Arrays.stream(WinState.values())
                .map(winState -> {
                    int winningCount = countPerWinStates.get(winState);
                    return winState.getWinStateInformation(winningCount);
                })
                .toList();
    }

}
