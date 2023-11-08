package lotto.view;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoCondition;
import lotto.global.Validator;
import lotto.global.util.Util;

public class Input {
    public static Integer getPurchaseAmount() {
        try {
            Integer amount = Util.parseIntOrThrowException(Console.readLine());
            Validator.checkAmount(amount);
            return amount;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getPurchaseAmount();
        }
    }

    public static Lotto getWinNumbers() {
        try {
            List<Integer> numbers =
                    Util.parseIntToListOrThrowException(Console.readLine(), LottoCondition.REGEX);
            return new Lotto(numbers);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinNumbers();
        }
    }

    public static Integer getBonusNumber(Lotto lotto) {
        try {
            Integer bonusNumber = Util.parseIntOrThrowException(Console.readLine());
            Validator.checkBonusNumber(bonusNumber, lotto.getNumbers());
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(lotto);
        }
    }
}
