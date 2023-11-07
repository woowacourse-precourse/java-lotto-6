package lotto.io;

import java.util.List;

public final class FakeLottoInput implements InputPort{
    @Override
    public int receiveMoney() {
        return 1000;
    }

    @Override
    public List<Integer> receiveLottos() {
        return List.of(1, 2, 3, 4, 5, 6);
    }

    @Override
    public int receiveBonus() {
        return 7;
    }
}
