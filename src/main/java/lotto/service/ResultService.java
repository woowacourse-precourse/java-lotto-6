package lotto.service;

import java.util.Arrays;
import java.util.List;
import lotto.dto.LottosDto;
import lotto.model.BonusNumber;
import lotto.model.Result;
import lotto.model.WinningNumber;

public class ResultService {
    private final List<Integer> result;

    public ResultService() {
        this.result = Arrays.asList(new Integer[]{0, 0, 0, 0, 0, 0});
    }

    public void calculateWinningStatistics(LottosDto purchasedLottos, WinningNumber winningNumber,
                                           BonusNumber bonusNumber) {
        List<Result> results = purchasedLottos.getLottoDtos().stream()
                .map((lotto) -> Result.calculate(lotto, winningNumber, bonusNumber))
                .toList();

    }
}
