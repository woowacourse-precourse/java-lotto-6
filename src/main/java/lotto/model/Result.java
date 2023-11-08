package lotto.model;

import java.util.List;
import lotto.dto.LottoDto;

public class Result {
    private static final Integer VALID_WINNING_MATCH_COUNT = 3;
    private static final Integer FIRST_PRIZE_COUNT = 6;
    private static final Integer UNDER_THIRD_PRIZE_COUNT = 5;
    private static final Integer FIRST_PRIZE = 1;
    private static final Integer SECOND_PRIZE = 2;
    private static final Integer THIRD_PRIZE = 3;
    private static final Integer SUM_OF_RANK_AND_MATCHED_COUNT = 8;

    private Integer prize = 0;

    private Result(List<Integer> lottoNumbers, WinningNumber winningNumber, BonusNumber bonusNumber) {
        Integer winningMatchedCount = winningNumber.compare(lottoNumbers);
        if (winningMatchedCount >= VALID_WINNING_MATCH_COUNT) {
            prize = calculate_prize(winningMatchedCount, lottoNumbers, bonusNumber);
        }
    }

    public static Result calculate(LottoDto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        return new Result(lotto.getLottoNumbers(), winningNumber, bonusNumber);
    }

    private Integer calculate_prize(Integer winningMatchedCount, List<Integer> lottoNumbers, BonusNumber bonusNumber) {
        if (winningMatchedCount == FIRST_PRIZE_COUNT) {
            return FIRST_PRIZE;
        }
        if (winningMatchedCount < UNDER_THIRD_PRIZE_COUNT) {
            return SUM_OF_RANK_AND_MATCHED_COUNT - winningMatchedCount;
        }
        if (bonusNumber.isBonusMatch(lottoNumbers)) {
            return SECOND_PRIZE;
        }
        return THIRD_PRIZE;
    }

    public Integer getPrize() {
        return prize;
    }
}
