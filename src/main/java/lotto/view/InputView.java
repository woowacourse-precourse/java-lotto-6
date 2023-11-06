package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.Amount;
import lotto.domain.WinningNumber;
import lotto.message.ExceptionMessage;

public class InputView {
    public Amount inputAmount(){
        Amount amount = null;
        while(amount == null){
            try {
                String input = Console.readLine();
                amount = new Amount(input);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    public WinningNumber inputPrizeNumber(){
        WinningNumber winningNumber = null;
        while(winningNumber == null){
            try {
                String input = Console.readLine();
                winningNumber =new WinningNumber(input);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return winningNumber;
    }

    public int inputBonusNumber(){
        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.INVALID_BONUS_TYPE.getMessage());
            throw new IllegalArgumentException();
        }
    }
}
