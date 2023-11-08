package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.util.ErrorCode;

public class userInput {

    public static int getInteger(){
        try {
            String CashIn = Console.readLine().strip();
            return Integer.parseInt(CashIn);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.INVALID_INTEGER_FORMAT.getMessage());
        }
    }

    public static List<Integer> getIntegerList(){
        try {
            String input = Console.readLine().strip();
            List<String> tokens = Arrays.stream(input.split(","))
                    .map(String::strip)
                    .toList();
            return tokens.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());}
        catch (NumberFormatException e){
            throw new IllegalArgumentException(ErrorCode.INVALID_INTEGER_FORMAT.getMessage());
        }
    }
}
