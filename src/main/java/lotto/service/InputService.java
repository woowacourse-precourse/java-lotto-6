package lotto.service;

import static lotto.settings.ErrorMessage.*;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class InputService {

    public static Integer number(){
        String input = readLine();
        validateTrim(input);
        validateNumber(input);
        return Integer.parseInt(input);
    }

    public static List<Integer> winningNumbers(){
        String input = readLine();
        String[] inputs = input.split(",", -1);
        validateTrim(inputs);
        validateNumber(inputs);
        return Arrays.stream(inputs).map(Integer::parseInt).toList();
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
        String trimInput = input.trim();
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
