package lotto.dto;

import java.util.Arrays;
import java.util.List;
import lotto.model.WinningLotto;
import lotto.model.WinningLottos;

public record TotalResults(List<TotalResult> totalResults, String rateOfReturn) {

    public static TotalResults of(WinningLottos winningLottos, String rateOfReturn) {
        return new TotalResults(Arrays.stream(WinningLotto.values())
                .map(winningLotto -> TotalResult.of(winningLotto, winningLottos.getWinningLottoCount(winningLotto)))
                .toList(),
                rateOfReturn);
    }
}
