package view;

import model.Bonus;
import model.Money;
import model.Winning;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Money getMoney() {
        return new Money(Console.readLine());
    }

    public Winning getWinning() {
        return new Winning(Console.readLine());
    }

    public Bonus getBonus(Winning winning) {
        return new Bonus(Console.readLine(), winning);
    }
}
