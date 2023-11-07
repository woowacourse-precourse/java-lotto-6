package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Bonus {
    private int bonus;

    public void inputBonus() {
        String bonusChar = Console.readLine();
        bonus = Integer.parseInt(bonusChar);

        validate(bonus);
    }

    private void validate(int bonus) {
        //번호가 1~45가 아닐 때
        if (bonus < 1 || bonus > 45) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 1~45이어야 합니다.");
        }
    }
}
