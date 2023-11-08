package lotto.service;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import lotto.dto.LottoDto;
import lotto.dto.LottosDto;
import lotto.dto.ResultDto;
import lotto.model.BonusNumber;
import lotto.model.Lotto;
import lotto.model.Result;
import lotto.model.WinningNumber;

public class ResultService {
    private final Integer FIRST_PRIZE_AMOUNT = 2000000000;
    private final Integer SECOND_PRIZE_AMOUNT = 30000000;
    private final Integer THIRD_PRIZE_AMOUNT = 1500000;
    private final Integer FOURTH_PRIZE_AMOUNT = 50000;
    private final Integer FIFTH_PRIZE_AMOUNT = 5000;
    private final Integer ADJUST_VALUE_FOR_INDEX = 1;
    private final Integer ONE_COUNT = 1;
    private final Integer MULTIPLE_FOR_PERCENT = 100;

    private final List<Integer> prizeAmount;
    private final List<Integer> totalResult;
    private Double returnRate = 0.0;

    public ResultService() {
        totalResult = Arrays.asList(0, 0, 0, 0, 0);
        prizeAmount = Arrays.asList(FIRST_PRIZE_AMOUNT, SECOND_PRIZE_AMOUNT,
                THIRD_PRIZE_AMOUNT, FOURTH_PRIZE_AMOUNT, FIFTH_PRIZE_AMOUNT);
    }

    public void calculateWinningStatistics(LottosDto purchasedLottos, WinningNumber winningNumber,
                                           BonusNumber bonusNumber) {
        for (LottoDto lottoDto : purchasedLottos.getLottoDtos()) {
            Result result = Result.calculate(lottoDto, winningNumber, bonusNumber);
            int resultIndex = result.getPrize() - ADJUST_VALUE_FOR_INDEX;
            if (resultIndex >= 0) {
                Integer currentValue = totalResult.get(resultIndex);
                totalResult.set(resultIndex, currentValue + ONE_COUNT);
            }
        }
    }

    public void calculateReturnRate(LottosDto purchasedLottos) {
        int purchasedPrice = purchasedLottos.getCountOfPurchase() * Lotto.PRICE;
        double unroundedReturnRate = (double) calculateTotalPrize() / purchasedPrice * MULTIPLE_FOR_PERCENT;
        returnRate = Math.round(unroundedReturnRate * 10.0) / 10.0;
    }

    private Integer calculateTotalPrize() {
        return IntStream.range(0, totalResult.size())
                .map(i -> totalResult.get(i) * prizeAmount.get(i))
                .sum();
    }

    public ResultDto getLottoResult() {
        return ResultDto.create(totalResult, returnRate);
    }
}
