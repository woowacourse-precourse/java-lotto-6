package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class userInput {

    public static int getInteger(){
        String CashIn = Console.readLine().strip();
        return Integer.parseInt(CashIn);
    }

    public static List<Integer> getIntegerList(){
        String input = Console.readLine().strip();

            List<String> tokens = Arrays.stream(input.split(","))
                    .map(String::strip)
                    .toList();

            return tokens.stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

    }

}
