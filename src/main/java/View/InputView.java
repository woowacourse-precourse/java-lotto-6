package View;

import Model.Bonus;
import Model.Money;
import Model.Winning;
import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public Money getMoney(){
        return new Money(Console.readLine());
    }

    public Winning getWinning(){
        return new Winning(Console.readLine());
    }

    public Bonus getBonus(Winning winning){
        return new Bonus(Console.readLine(), winning);
    }
}
