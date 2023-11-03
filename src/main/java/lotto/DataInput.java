package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInput {
    public int userInputPayment(){
        String userPayment;
        userPayment = Console.readLine();
        // Validate
        return Integer.parseInt(userPayment);
    }

    public List<Integer> userInputWinningNumbers(){
        StringTokenizer winningNumbersTokenizer = new StringTokenizer(Console.readLine(), ",");
        List<Integer> winningNumbers = new ArrayList<>();
        String curToken;
        int curNumber;

        while(winningNumbersTokenizer.hasMoreTokens()){
            curToken = winningNumbersTokenizer.nextToken();
            curNumber = Integer.parseInt(curToken);
            // Validate
            winningNumbers.add(curNumber);
        }

        return winningNumbers;
    }

    public int userInputBonusNumber(){
        String userBonusNumber;
        userBonusNumber = Console.readLine();
        // Validate
        return Integer.parseInt(userBonusNumber);
    }
}
