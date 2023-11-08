package view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class InputView {

    public int inputPayNumber() {
        String input = readLine();
        return Integer.valueOf(input);
    }

    public List<Integer> inputWinnerNumber() {
        List<Integer> inputNumbers = new ArrayList<>();
        String input = readLine();
        String[] stringNumber = input.split(",");

        for(String numberString: stringNumber) {
            int number = Integer.parseInt(numberString.trim());
            inputNumbers.add(number);
        }

        return inputNumbers;
    }

    public int inputBonusNumber() {
        String input = readLine();
        return Integer.valueOf(input);
    }

}
