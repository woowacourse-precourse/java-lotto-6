package lotto.dto;

import java.util.Arrays;
import java.util.List;
import lotto.model.WinningLotto;
import lotto.model.WinningLottos;

public record Results(List<Result> results, String rateOfReturn) {

    public static Results of(WinningLottos winningLottos, String rateOfReturn) {
        return new Results(Arrays.stream(WinningLotto.values())
                .map(winningLotto -> Result.of(winningLotto, winningLottos.getWinningLottoCount(winningLotto)))
                .toList(),
                rateOfReturn);
    }
}
