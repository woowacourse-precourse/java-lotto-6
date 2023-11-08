package lotto.View;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.ArrayList;

public class Input {
    public static Integer insertInteger(){
        String inputValue = Console.readLine();
        InputValidator.validateInsertInteger(inputValue);
        return Integer.parseInt(inputValue);
    }

    public static String insertString(){
        String inputValue = Console.readLine().trim();
        InputValidator.validateInsertString(inputValue);
        return inputValue;

    }


}
