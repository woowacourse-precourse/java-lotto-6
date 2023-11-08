package lotto.publisher;

import java.io.IOException;
import java.util.List;
import lotto.lotto.Lotto;

public interface Publisher {
    List<Lotto> publish(int number) throws IOException;
}
