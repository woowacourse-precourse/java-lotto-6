package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.CashRegister;
import lotto.util.SortedRandomNumberGenerator;

public class LottoGenerator {
    private final CashRegister cashRegister = new CashRegister();
    private final SortedRandomNumberGenerator sortedRandomNumberGenerator;

    public LottoGenerator(SortedRandomNumberGenerator sortedRandomNumberGenerator) {
        this.sortedRandomNumberGenerator = sortedRandomNumberGenerator;
    }

    public List<Lotto> generateForAmount(int amount) {
        int count = cashRegister.calculateLottoCount(amount);
        return IntStream.range(0, count)
                .mapToObj(i -> new Lotto(sortedRandomNumberGenerator.generate()))
                .collect(Collectors.toList());
    }
}
