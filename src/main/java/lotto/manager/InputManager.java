package lotto.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {
    public int inputInt(String message) {
        System.out.println(message);
        String input = Console.readLine();
        // validate Integer
        return Integer.parseInt(input);
    }

    public List<Integer> inputMultipleInt(String message) {
        System.out.println(message);
        String input = Console.readLine();
        return stringListToIntList(Arrays.asList(input.split(",")));
    }

    private List<Integer> stringListToIntList(List<String> strings) {
        List<Integer> integers = new ArrayList<Integer>();
        for (int i = 0; i < strings.size(); i++) {
            integers.add(Integer.parseInt(strings.get(i)));
        }
        return integers;
    }
}
