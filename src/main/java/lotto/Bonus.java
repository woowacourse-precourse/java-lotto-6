package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Bonus {
    private int bonus;

    public void inputBonus() {
        String bonusChar = Console.readLine();
        bonus = Integer.parseInt(bonusChar);
    }
}
