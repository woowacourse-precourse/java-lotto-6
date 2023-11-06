package service;

import domain.Amount;
import domain.Lotto;
import domain.Lottos;
import domain.WinningNumbers;
import java.util.List;

public class MakeObjectService {

    public static Amount amount(int input) {
        return new Amount(input);
    }

    public static Lottos lottos(Amount amount) {
        return new Lottos(amount);
    }

    public static Lotto lotto() {
        return new Lotto();
    }

    public static Lotto lotto(List<Integer> numbers) {
        return new Lotto(numbers);
    }
}
