package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoGenerator {
    private final CashRegister cashRegister = new CashRegister();
    private final SortedRandomNumberGenerator sortedRandomNumberGenerator;

    public LottoGenerator(SortedRandomNumberGenerator sortedRandomNumberGenerator) {
        this.sortedRandomNumberGenerator = sortedRandomNumberGenerator;
    }

    public List<Lotto> generateForAmount(int amount) {
        int count = cashRegister.calculateLottoCount(amount);

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            lottos.add(new Lotto(sortedRandomNumberGenerator.generate()));
        }
        return lottos;
    }
}
