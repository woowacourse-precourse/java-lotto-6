package lotto.publisher;

import java.util.List;
import lotto.lotto.Lotto;

public interface Publisher {
    List<Lotto> publish(int number);
}
