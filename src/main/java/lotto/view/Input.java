package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Input {

    private static final String PRINT_COST = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";

    public String getCost(){
        System.out.println(PRINT_COST);
        String input = "";
        try{
            input = Console.readLine();
            if(!Pattern.matches("^[0-9]*$",input)){
                System.out.println("input  --    "     + input);
                throw new IllegalArgumentException("[ERROR] Cost should have only number.");
            }
            return input;
        } catch (IllegalArgumentException e){
            System.out.println("Cost should have only number!!!!!\n");
            return getCost();
        }
    }

    public String getWinningNumber(){
        System.out.println(PRINT_WINNING_NUMBER);
        String input = Console.readLine();
        validateWinningNumber(input);
        return input;
    }

    public String getBonusNumber(){
        System.out.println(PRINT_BONUS_NUMBER);
        String input = "";
        try{
            input = Console.readLine();
            if(!Pattern.matches("^[0-9]*$",input)){
                System.out.println("input  --    "     + input);
                throw new IllegalArgumentException("[ERROR] Bonus number should have only number.");
            }
            return input;
        } catch (IllegalArgumentException e){
            System.out.println("Bonus number should have only number!!!!!\n");
            return getCost();
        }
    }

    private void validateString(String input){
        try{
            if(!Pattern.matches("^[0-9]*$",input)){
                throw new IllegalArgumentException("[ERROR] Cost should have only number.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Cost should have only number.");
            getCost();
        }
    }

    private void validateInteger(int input){
        try{
            if(!(input%1000 == 0)){
                throw new IllegalArgumentException("[ERROR] Cost should be divided by 1000.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("Cost should be divided by 1000.");
            //getCost();
        }
    }

    private void validateWinningNumber(String input){
        try{
            if(!Pattern.matches("^[0-9,]+$",input)){
                throw new IllegalArgumentException("[ERROR] There are another symbols other than number and comma.");
            }
        } catch (IllegalArgumentException e){
            System.out.println("There are another symbols other than number and comma.");
            getWinningNumber();
        }

    }

    private int stringToInt(String input){
        return Integer.parseInt(input);
    }

}

