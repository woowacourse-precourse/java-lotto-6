package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    private int readInputNumber() {
        String amount = Console.readLine();
        return convertNumber(amount);
    }

    private List<Integer> readInputTargetNumbers() {
        String[] targetStrings = Console.readLine().split(",");
        List<Integer> targetNumbers = new ArrayList<>();
        for (String string : targetStrings) {
            targetNumbers.add(convertNumber(string));
        }
        return targetNumbers;
    }

    private static int convertNumber(String inStream) {
        try {
            int convertedNum = Integer.parseInt(inStream);
            return convertedNum;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
