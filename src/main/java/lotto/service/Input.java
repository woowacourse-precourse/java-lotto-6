package lotto.service;

import static lotto.settings.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import lotto.view.View;

public class Input {

    public static Integer number(){
        while(true){
            View.requestPurchaseAmount();
            String input = readLine();
            try{
                validateTrim(input);
                validateNumber(input);
                return Integer.parseInt(input);
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
        }
    }

    public static Integer bonusNumber(){
        while(true){
            View.requestBonusNumber();
            String input = readLine();
            try{
                validateTrim(input);
                validateNumber(input);
                return Integer.parseInt(input);
            }catch (IllegalArgumentException e){
                System.out.print(e.getMessage());
            }
        }
    }

    public static List<Integer> winningNumbers(){
        while(true){
            View.requestWinningNumber();
            String input = readLine();
            String[] inputs = input.split(",", -1);
            try {
                validateTrim(inputs);
                validateNumber(inputs);
                return Arrays.stream(inputs).map(Integer::parseInt).toList();
            } catch (IllegalArgumentException e) {
                System.out.print(e.getMessage());
            }
        }
    }

    private static void validateNumber(String input) {
        try{
            Integer.parseInt(input);
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
    private static void validateNumber(String[] inputs) {
        try{
            for (String input : inputs) {
                Integer.parseInt(input);
            }
        }catch (Exception e){
            throw new IllegalArgumentException(INVALID_NUMBER_FORMAT.getMessage());
        }
    }
    private static void validateTrim(String input) {
        String trimInput = input.replaceAll(" ","");
        if(input.length() != trimInput.length()){
            throw new IllegalArgumentException(CONTAIN_SPACE.getMessage());
        }
    }

    private static void validateTrim(String[] input) {
        for (String s : input) {
            if(s.isBlank()){
                throw new IllegalArgumentException(CONTAIN_SPACE.getMessage());
            }
        }
    }

    private static String readLine(){
        return Console.readLine();
    }
}
