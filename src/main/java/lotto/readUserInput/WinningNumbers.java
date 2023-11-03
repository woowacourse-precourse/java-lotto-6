package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    public static List<Integer> numbers = new ArrayList<>();

    public void read() {
        String[] numbers = separateUserInput(userInput());
        addWinningNumbers(numbers);
    }

    public String userInput() {
        return Console.readLine();
    }

    public String[] separateUserInput(String inputNumbers) {
        return inputNumbers.split(",");
    }

    public int singleTypeConversion(String readSingleNumber) {
        return Integer.parseInt(readSingleNumber);
    }

    public void addWinningNumbers(String[] readNumbers) {
        while(numbers.size() < 6) { // 상수로 표현 가능.
            numbers.add(singleTypeConversion(readNumbers[numbers.size()]));
        }
    }
}
