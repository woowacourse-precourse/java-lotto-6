package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInput {
    Validation validator = new Validation();

    DataInput(){}

    public int userInputPayment(){
        String userInput;
        int userPayment;

        while(true){
            userInput = Console.readLine();
            try{
                userPayment = Integer.parseInt(userInput);
                if(validator.isPaymentDivided(userPayment)){
                    throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위이어야 합니다.");
                }
                return userPayment;
            } catch (IllegalArgumentException e){
                System.out.println("[ERROR] 유효하지 않은 값입니다.");
            }
        }
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
