package lotto.View;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public static Integer insertInteger(){
        String inputValue = Console.readLine().trim();
        InputValidator.exceptInsertInteger(inputValue);
        return Integer.parseInt(inputValue);
    }


}
