package lotto.readUserInput;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class WinningNumbers {
    public static List<Integer> numbers;

    public void read() {
        String[] numbers = seperateUserInput(userInput());
        addWinningNumbers(numbers);
    }

    public String userInput() {
        return Console.readLine();
    }

    public String[] seperateUserInput(String inputNumbers) {
        return inputNumbers.split(",");
    }

    public int SingleTypeConversion(String readSingleNumber) {
        return Integer.parseInt(readSingleNumber);
    }

    public void addWinningNumbers(String[] readNumbers) {
        while(numbers.size() < 6) { // 상수로 표현 가능.
            numbers.add(SingleTypeConversion(readNumbers[numbers.size()]));
        }
    }
}
