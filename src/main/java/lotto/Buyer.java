package lotto;

import java.util.List;

public class Buyer {
    private Lotto lotto;
    private int bonus;

    private Buyer(Lotto lotto, int bonus) {
        this.lotto = lotto;
        this.bonus = bonus;
    }

    public static Buyer create(Lotto lotto, int bonus) {
        return new Buyer(lotto, bonus);
    }

    public int countMatchNumber(Lotto numbers) {
        List<Integer> lottoNumbers = numbers.getLottoNumbers();

        return (int) lottoNumbers.stream()
                .filter(numbers::contain)
                .count();
    }

    private boolean hasBonus(Lotto numbers) {
        return numbers.contain(bonus);
    }
}
