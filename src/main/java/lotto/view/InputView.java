package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int inputAmount(){
        return Integer.parseInt(Console.readLine());
    }
    public String winningNumber(){
        return Console.readLine();
    }
    public int bonusNumber(){
        return Integer.parseInt(Console.readLine());
    }
}
