package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class DataInput {
    Validation validator = new Validation();

    public int userInputPayment(){
        String userInput;
        int userPayment;

        while(true){
            userInput = Console.readLine();
            try{
                userPayment = Integer.parseInt(userInput);
                validator.isPaymentDivided(userPayment);
                return userPayment;
            } catch(NumberFormatException e){
                System.out.println(Progress.ERROR_INTEGER.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
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
                    validator.isWinningValidate(winningNumbers, curNumber);
                    winningNumbers.add(curNumber);
                }
                validator.isWinningSetValidate(winningNumbers);
                return winningNumbers;
            } catch(NumberFormatException e){
                System.out.println(Progress.ERROR_INTEGER.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public int userInputBonusNumber(List<Integer> winningNumbers){
        String userBonusNumberInput;
        int userBonusNumber;

        while(true){
            try{
                userBonusNumberInput = Console.readLine();
                userBonusNumber = Integer.parseInt(userBonusNumberInput);
                validator.isBonusValidate(winningNumbers, userBonusNumber);
                return userBonusNumber;
            } catch(NumberFormatException e){
                System.out.println(Progress.ERROR_INTEGER.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
