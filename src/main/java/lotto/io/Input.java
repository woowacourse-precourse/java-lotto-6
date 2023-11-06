package lotto.io;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.LottoAnswer;
import lotto.domain.Money;

public class Input {
    public Money setMoney() {
        return new Money(Console.readLine());
    }

    public LottoAnswer setLottoAnswer() {
        return new LottoAnswer(Console.readLine());
    }

    public BonusNumber setBonusNumber() {
        int num;
        try {
            num = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바르지 않은 입력입니다.");
        }
        return new BonusNumber(num);
    }
}
