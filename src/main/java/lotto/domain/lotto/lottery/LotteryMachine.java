package lotto.domain.lotto.lottery;

import java.util.List;

public interface LotteryMachine<T> {
    List<T> generate();
}
