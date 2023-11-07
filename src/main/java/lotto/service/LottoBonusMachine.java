package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;

public class LottoBonusMachine {
    private static final String bonusNumberMessage = "\n보너스 번호를 입력해 주세요.";
    private static final String errorMessageInputType = "[ERROR] 로또 번호는 숫자여야 합니다.";

    public BonusNumber lottoBonusNumber(Lotto lotto) {
        while (true) {
            try {
                BonusNumber bonus = new BonusNumber(bonusNumber(), lotto);
                return bonus;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int bonusNumber() {
        System.out.println(bonusNumberMessage);
        String input = Console.readLine();

        return validateType(input);
    }

    private int validateType(String input) {
        try {
            int bonus = Integer.parseInt(input);
            return bonus;
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(errorMessageInputType);
        }
    }
}
