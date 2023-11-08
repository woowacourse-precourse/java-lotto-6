package lotto.manager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

import camp.nextstep.edu.missionutils.Console;

public class InputManager {

    public int inputInt(String message) {
        System.out.println(message);
        String input = Console.readLine();
        while (!validateInputInt(input)) {
            System.out.println(message);
            input = Console.readLine();
        }
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

    private boolean validateInputInt(String input) {
        if (!isInteger(input)) {
            try {
                throw new IllegalArgumentException("[ERROR] 숫자가 아닙니다.");
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return false;
            }
        }
        return true;
    }

    private boolean isInteger(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
