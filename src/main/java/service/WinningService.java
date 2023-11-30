package service;

import domain.BonusNumber;
import domain.Lotto;
import domain.WinningNumbers;
import domain.WinningResult;
import dto.WinningResultDto;

import java.util.List;

public class WinningService {

    private WinningResult winningResult;

    public WinningNumbers createWinningNumbers(final List<Integer> winningNumbers){
        return WinningNumbers.create(winningNumbers);
    }

    public BonusNumber createBonusNumber(final int bonusNumber){
        return BonusNumber.create(bonusNumber);
    }

    public WinningResult createWinningResult(final WinningNumbers winningNumbers, final BonusNumber bonusNumber){
        winningResult = WinningResult.create(winningNumbers, bonusNumber);
        return winningResult;
    }

    public WinningResultDto calculateProfitAndRateOfProfit(final List<Lotto> lottos, final int purchaseAmount){
        calculateProfit(lottos);
        calculateRateOfProfit(purchaseAmount);
        return WinningResultDto.create(winningResult);
    }

    private void calculateProfit(final List<Lotto> lottos){
        winningResult.calculateProfit(lottos);
    }

    private void calculateRateOfProfit(final int purchaseAmount){
        winningResult.calculateRateOfProfit(purchaseAmount);
    }
}
