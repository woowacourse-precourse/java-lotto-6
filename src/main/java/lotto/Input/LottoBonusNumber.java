package lotto.Input;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class LottoBonusNumber {
    private final Integer bonus;


    public LottoBonusNumber() {
        this.bonus = bonusNumber();
    }

    public Integer getBonus() {
        return bonus;
    }

    public Integer bonusNumber() {
        Integer bonus;
        boolean validNumber = false;
        while (true) {
            try {
                bonus = Integer.parseInt(readLine());
                if (bonus > 45 || bonus < 1) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] 1~45 사이의 숫자만 입력 가능합니다.");
            }
        }
        return bonus;
    }
}
