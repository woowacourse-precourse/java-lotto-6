package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import lotto.constants.LottoConstants;
import lotto.constants.LottoReward;
import lotto.dto.WinningResultDto;

public class WinningResult {
    private final EnumMap<LottoReward, Integer> winningResult;

    private WinningResult(EnumMap<LottoReward, Integer> winningResult) {
        this.winningResult = winningResult;
    }

    public static WinningResult create() {
        EnumMap<LottoReward, Integer> winningResult = new EnumMap<>(LottoReward.class);
        Arrays.stream(LottoReward.values())
                .forEach(winningReward -> winningResult.put(winningReward, 0));
        return new WinningResult(winningResult);
    }

    public void calWinningResult(WinningLotto winningLotto, Lottos lottos) {
        lottos.getLottos().stream()
                .map(lotto -> LottoReward.getWinningReward(lotto.getMatchLottoCount(winningLotto),
                        lotto.isContain(winningLotto.getBonusNumber().getBonusNumber())))
                .forEach(this::updateWinningCount);
    }

    private void updateWinningCount(LottoReward winningReward) {
        winningResult.put(winningReward,
                winningResult.get(winningReward) + LottoConstants.PRIZE_COUNT_INCREMENT.getNumber());
    }

    public Integer getWinningCount(LottoReward winningReward) {
        return winningResult.get(winningReward);
    }

    public WinningResultDto toDto() {
        return new WinningResultDto(winningResult);
    }
}
