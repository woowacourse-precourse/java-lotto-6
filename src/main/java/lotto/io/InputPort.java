package lotto.io;

import java.util.List;

public interface InputPort {
    List<Integer> receiveLottos();
    Integer receiveBonus();
}
