package lotto.scanner;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;

public class BonusNumberGameScanner implements GameScanner<BonusNumber> {

    @Override
    public BonusNumber scan() {
        String scannedValue = Console.readLine();
        Integer value = Integer.parseInt(scannedValue);

        return new BonusNumber(value);
    }
}
