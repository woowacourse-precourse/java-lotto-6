package lotto.scanner;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class MoneyGameScanner implements GameScanner<Money> {

    @Override
    public Money scan() {
        String scannedValue = Console.readLine();
        Long value = Long.parseLong(scannedValue);

        return new Money(value);
    }
}
