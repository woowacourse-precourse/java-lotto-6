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
        String curToken;
        int curNumber;

        while(true){
            try{
                StringTokenizer winningNumbersTokenizer = new StringTokenizer(Console.readLine(), ",");
                List<Integer> winningNumbers = new ArrayList<>();
                while(winningNumbersTokenizer.hasMoreTokens()){
                    curToken = winningNumbersTokenizer.nextToken();
                    curNumber = Integer.parseInt(curToken);
                    if(curNumber > 45 || curNumber < 1){
                        throw new IllegalArgumentException("[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.");
                    }
                    if(winningNumbers.contains(curNumber)){
                        throw new IllegalArgumentException("[ERROR] 중복된 번호는 입력할 수 없습니다.");
                    }
                    winningNumbers.add(curNumber);
                }
                if(winningNumbers.size() != 6){
                    throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개를 입력해야 합니다.");
                }
                return winningNumbers;
            } catch (IllegalArgumentException e){
                System.out.println(e);
            }
        }
    }

    public int userInputBonusNumber(){
        String userBonusNumber;
        userBonusNumber = Console.readLine();
        // Validate
        return Integer.parseInt(userBonusNumber);
    }
}
