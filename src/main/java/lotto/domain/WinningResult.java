package lotto.domain;

import java.util.EnumMap;
import java.util.Map;

public class WinningResult {
    private Map<WinningType, Integer> winningResult;

    private WinningResult(Lottos lottos, DrawnNumbers drawnNumbers) {
        this.winningResult = new EnumMap<>(WinningType.class);
        generateWinningResult(lottos, drawnNumbers);
    }

    public static WinningResult of(Lottos lottos, DrawnNumbers drawnNumbers) {
        return new WinningResult(lottos, drawnNumbers);
    }

    private void generateWinningResult(Lottos lottos, DrawnNumbers drawnNumbers) {
        for (Lotto lotto : lottos.getLottos()) {
            LottoResultDto lottoResultDto = drawnNumbers.compare(lotto);
            WinningType winningType = WinningType.findWinningType(
                    lottoResultDto.getWinningCount(),
                    lottoResultDto.hasBonusNumber());
        }
    }
}
