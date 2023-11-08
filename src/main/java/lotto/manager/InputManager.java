package lotto.manager;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputManager {
    public String getUserInput() {
        return Console.readLine();
    }

    public List<Integer> splitAndConvertToList(String inputNumbers) {
        List<Integer> numbers = new ArrayList<>();
        String[] parts = inputNumbers.split(",");
        for (String part : parts) {
            int number = Integer.parseInt(part);
            numbers.add(number);
        }
        return numbers;
    }
}
