package service;

import domain.Amount;
import domain.BonusNumber;
import domain.Lotto;
import domain.Lottos;
import domain.Rank;
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

    public static BonusNumber bonusNumber(int number, Lotto lotto) {
        return new BonusNumber(number, lotto);
    }

    public static WinningNumbers winningNumbers(Lotto lotto, BonusNumber bonusNumber) {
        return new WinningNumbers(lotto, bonusNumber);
    }

    public static Rank rank(List<Integer> rank) {
        return new Rank(rank);
    }
}
