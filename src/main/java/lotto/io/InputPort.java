package lotto.io;

import java.util.List;

public interface InputPort {
    Integer receiveMoney();
    List<Integer> receiveLottos();
    Integer receiveBonus();
}
