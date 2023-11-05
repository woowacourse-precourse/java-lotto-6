package lotto.util;

import camp.nextstep.edu.missionutils.Console;

public class InputUtil {

    public static int readAmount(){
        String input = Console.readLine();
        Validation.validateAmount(input);
        return Integer.parseInt(input);
    }
}
