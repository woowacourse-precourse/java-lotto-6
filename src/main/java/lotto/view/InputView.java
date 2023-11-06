package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import lotto.domain.WinningNumber;
import lotto.message.ExceptionMessage;

public class InputView {
    public int inputAmount(){
        try {
            String input = Console.readLine();

            return Integer.parseInt(input);
        }catch (NumberFormatException e) {
            System.out.println(ExceptionMessage.INVALID_AMOUNT_TYPE.getMessage());
            throw new IllegalArgumentException();
        }
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
