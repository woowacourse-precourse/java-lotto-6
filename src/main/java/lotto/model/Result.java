package lotto.model;

import java.util.List;
import lotto.dto.LottoDto;

public class Result {
    private Integer prize = 0;

    private Result(List<Integer> lottoNumbers, WinningNumber winningNumber, BonusNumber bonusNumber) {
        Integer winningMatchedCount = winningNumber.compare(lottoNumbers);
        if (winningMatchedCount >= 3) {
            prize = calculate_prize(winningMatchedCount, lottoNumbers, bonusNumber);
        }
    }

    public static Result calculate(LottoDto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return new Result(lotto.getLottoNumbers(), winningNumber, bonusNumber);
    }

    private Integer calculate_prize(Integer winningMatchedCount, List<Integer> lottoNumbers, BonusNumber bonusNumber) {
        if (winningMatchedCount == 6) {
            return 1;
        }
        if (winningMatchedCount < 5) {
            return 8 - winningMatchedCount;
        }
        if (bonusNumber.isBonusMatch(lottoNumbers)) {
            return 2;
        }
        return 3;
    }

    public Integer getPrize() {
        return prize;
    }
}
