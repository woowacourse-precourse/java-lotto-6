package lotto.model;

import java.util.List;
import java.util.Optional;

public class WinningNumber {

    Lotto winningNumber;
    int bonusNumber;

    public WinningNumber(Lotto winningNumber, int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
    }

    public Result calculateLottosWinningResult(List<Lotto> lottos) {

        List<Winning> winnings = lottos.stream()
                .map(userLotto -> calculateLottoWinningResult(userLotto))
                .filter(winning -> winning.isPresent())
                .map(winning -> winning.get())
                .toList();

        Result result = new Result();
        result.put(winnings);
        return result;
    }

    public Optional<Winning> calculateLottoWinningResult(Lotto userLotto) {

        int numberOfMatchingLottoNumbers = findNumberOfMatchingLottoNumbers(userLotto);

        boolean hasBonusNumber = isMatchingWithBonusNumberWhenCountIs5(userLotto, bonusNumber,
                numberOfMatchingLottoNumbers);

        return Winning.findWinning(numberOfMatchingLottoNumbers, hasBonusNumber);
    }

    public int findNumberOfMatchingLottoNumbers(Lotto userLotto) {
        return winningNumber.calculateSameNumber(userLotto);
    }

    public boolean isMatchingWithBonusNumberWhenCountIs5(Lotto userLotto, int bonusNumber,
            int matchingCount) {
        if (matchingCount == 5) {
            return userLotto.contains(bonusNumber);
        }
        return false;
    }
}