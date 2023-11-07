package lotto.io.reader;

import java.math.BigDecimal;

public interface Reader {
    String readLine();

    BigDecimal readMoney();
}
