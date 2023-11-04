package lotto.view;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public String inputValue(String message) {
        System.out.println(message);
        String input = Console.readLine();
        Console.close();
        return input;
    }
}
