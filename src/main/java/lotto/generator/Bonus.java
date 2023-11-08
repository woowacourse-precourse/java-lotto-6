package lotto.generator;

import camp.nextstep.edu.missionutils.Console;
import lotto.handler.ExceptionHandler;

public class Bonus {

    public static int getBonus() {
        System.out.println("\n보너스 번호를 입력해 주세요.");
        String rawBonus = Console.readLine();

        int bonus = Integer.parseInt(rawBonus);
        bonus = updateBonusWithValidation(rawBonus, bonus);

        return bonus;
    }

    private static int updateBonusWithValidation(String rawBonus, int bonus) {
        while (true) {
            try {
                ExceptionHandler.checkNull(rawBonus);
                ExceptionHandler.checkNumberFormat(rawBonus);
                checkBonus(bonus);
                return bonus;
            } catch (IllegalArgumentException | NullPointerException e) {
                ExceptionHandler.handle(e);
                rawBonus = Console.readLine();
                bonus = Integer.parseInt(rawBonus);
            }
        }
    }

    private static void checkBonus(int bonus) {
        try {
            if (bonus < 1 || bonus > 45) {
                throw new IllegalArgumentException("Input number between 1 and 45. \n └─ errorVar : " + bonus);
            }
        } catch (IllegalArgumentException e) {
            ExceptionHandler.handle(e);
        }
    }
}
