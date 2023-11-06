package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.LottoAnswer;
import lotto.domain.Money;

public class Input {
    public Money setMoney() {
        return new Money(Console.readLine());
    }

    public LottoAnswer setLottoAnswer(){
        return new LottoAnswer(Console.readLine());
    }
}
