package lotto.model;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public int inputInt(String message) {
        System.out.println(message);
        String input = Console.readLine();
        // validate Integer
        return Integer.parseInt(input);
    }

//    public List<Integer> inputMultipleInt(String str) {
//
//    }
}
