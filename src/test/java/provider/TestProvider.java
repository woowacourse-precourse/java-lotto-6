package provider;

import domain.BonusNumber;
import domain.Lottos;
import domain.WinningNumbers;
import domain.WinningResult;

import java.util.List;

public class TestProvider {
    public static Lottos createTestPurchaseLottos(final int numberOfPurchased) {
        return Lottos.create(numberOfPurchased);
    }

    public static WinningNumbers createTestWinningNumbers(final List<Integer> numbers){
        return WinningNumbers.create(numbers);
    }

    public static BonusNumber createTestBonusNumber(final int number){
        return BonusNumber.create(number);
    }

    public static WinningResult createWinningResult(final WinningNumbers winningNumbers, final BonusNumber bonusNumber){
        return WinningResult.create(winningNumbers, bonusNumber);
    }
}
