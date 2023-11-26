package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class Input {

    private static final String PRINT_COST = "구입금액을 입력해 주세요.";
    private static final String PRINT_WINNING_NUMBER = "당첨 번호를 입력해 주세요.";
    private static final String PRINT_BONUS_NUMBER = "\n보너스 번호를 입력해 주세요.";
    private static final String NUMBER_REGEX = "^[0-9]*$";
    private static final String LOTTO_NUMBERS_REGEX = "^[0-9,]+$";


    public String getCost(){
        System.out.println(PRINT_COST);
        String input = "";
        try{
            input = Console.readLine();
            validateInput(input);
            validateMatchPattern(NUMBER_REGEX,input);
            return input;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getCost();
        }
    }

    public String getWinningNumber(){
        System.out.println(PRINT_WINNING_NUMBER);
        String input = "";
        try{
            input = Console.readLine();
            validateInput(input);
            validateWinningNumber(input);
            return input;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

    public String getBonusNumber(){
        System.out.println(PRINT_BONUS_NUMBER);
        String input = "";
        try{
            input = Console.readLine();
            validateInput(input);
            validateMatchPattern(NUMBER_REGEX,input);
            return input;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return getBonusNumber();
        }
    }

    private void validateWinningNumber(String input){
        if(!matchPattern(LOTTO_NUMBERS_REGEX,input)){
            throw new IllegalArgumentException("[ERROR] There are another symbols other than number and comma.");
        }
    }

    private void validateInput(String input){
        if(input.isEmpty()){
            throw new IllegalArgumentException("[ERROR] You should enter input.");
        }
    }

    private void validateMatchPattern(String regex, String input){
        if(!matchPattern(regex,input)){
            throw new IllegalArgumentException("[ERROR] You should enter only number.");
        }
    }

    private boolean matchPattern(String regex, String input){
        return Pattern.matches(regex,input);
    }

}

