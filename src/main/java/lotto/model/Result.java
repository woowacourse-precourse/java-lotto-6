package lotto.model;

import java.util.List;
import lotto.dto.LottoDto;

public class Result {
    private Integer prize = 0;

    private Result(List<Integer> lottoNumbers, WinningNumber winningNumber, BonusNumber bonusNumber) {
        Integer winningMatchedCount = winningNumber.compare(lottoNumbers);
        prize = calculate_prize(winningMatchedCount, bonusNumber);
    }

    private Integer calculate_prize(Integer winningMatchedCount, BonusNumber bonusNumber) {
        if (winningMatchedCount < 5) {
            return 8 - winningMatchedCount;
        }
        if (winningMatchedCount == 6) {
            return 1;
        }
        return 0;
    }

    public static Result calculate(LottoDto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return new Result(lotto.getLottoNumbers(), winningNumber, bonusNumber);
    }

    public Integer getPrize() {
        return prize;
    }
}
