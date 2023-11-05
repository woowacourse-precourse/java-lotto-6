package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Money;

public class LottoInputView {

    public Money getLottoPurchase() {
        try {
            int amount = Integer.parseInt(Console.readLine());
            return new Money(amount);
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException("문자는 입력할 수 없습니다");
        }
    }

}
