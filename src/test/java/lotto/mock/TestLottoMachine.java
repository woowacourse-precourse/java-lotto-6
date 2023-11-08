package lotto.mock;

import java.util.List;
import lotto.domain.lottomachine.LottoMachine;

public class TestLottoMachine implements LottoMachine {
    private int seed = 1;

    @Override
    public List<Integer> generate() {
        List<Integer> result = List.of(seed, seed + 1, seed + 2, seed + 3, seed + 4, seed + 5);
        seed++;
        return result;
    }
}
