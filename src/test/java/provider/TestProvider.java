package provider;

import domain.Lottos;
import domain.WinningNumbers;

import java.util.List;

public class TestProvider {
    public static Lottos createTestPurchaseLottos(final int numberOfPurchased) {
        return Lottos.create(numberOfPurchased);
    }

    public static WinningNumbers createTestWinningNumbers(final List<Integer> numbers){
        return WinningNumbers.create(numbers);
    }
}
