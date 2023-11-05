package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.validator.WinningNumValidator;

import java.util.ArrayList;
import java.util.List;

public class InputView {

    public static String inputMoney(){
        return Console.readLine();
    }

    public static List<Integer> inputWinningNum(){
        while(true){
            String input = Console.readLine();
            try{
                WinningNumValidator winningNumValidator = new WinningNumValidator(input);
                return parseStirngToInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String inputBonusNum(){
        return Console.readLine();
    }

    public static List<Integer> parseStirngToInt(String input){
        List<Integer> winningNumber = new ArrayList<>();
        for(String number : input.split(",")){
            winningNumber.add(Integer.parseInt(number));
        }
        return winningNumber;
    }

}
