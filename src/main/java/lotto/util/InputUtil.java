package lotto.util;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class InputUtil {

    public static int readAmount(){
        String input = Console.readLine();
        Validation.validateAmount(input);
        return Utils.stringToInteger(input);
    }

    public static List<Integer> readWinningNumbers(){
        String input = Console.readLine();
        List<String> numbers = List.of(input.split(","));
        Validation.validateConditions(input, numbers);

        return Utils.stringToIntegerList(numbers);
    }

    public static int readBonus(){
        String input = Console.readLine();
        Validation.validateInteger(input);
        return Utils.stringToInteger(input);
    }
}
