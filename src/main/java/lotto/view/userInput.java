package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class userInput {

    public static int getInteger(){
        String CashIn = Console.readLine().strip();
        return Integer.parseInt(CashIn);
    }

    public static List<String> getIntegerList(){
        String winningNumberInput = Console.readLine().strip();
        return Arrays.asList(winningNumberInput.split(","));
    }

}
