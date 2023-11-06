package lotto.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class InputView {
    public static int readInputNumber() {
        String amount = Console.readLine();
        System.out.println(amount);
        return convertNumber(amount);
    }

    public static List<Integer> readInputTargetNumbers() {
        String[] targetStrings = Console.readLine().split(",");
        List<Integer> targetNumbers = new ArrayList<>();
        System.out.println(targetNumbers);
        for (String string : targetStrings) {
            targetNumbers.add(convertNumber(string));
        }
        return targetNumbers;
    }

    private static int convertNumber(String inStream) {
        try {
            int convertedNum = Integer.parseInt(inStream);
            if (convertedNum > 0) {
                return convertedNum;
            }
            else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
