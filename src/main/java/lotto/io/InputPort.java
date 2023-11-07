package lotto.io;

import java.util.List;

public interface InputPort {
    int receiveMoney();
    List<Integer> receiveLottos();
    int receiveBonus();
}
