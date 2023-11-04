package lotto.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import lotto.Validator;
import lotto.domain.Computer;

public class Input {

    public static String get() {
        return Console.readLine();
    }

    // 자료형 조작, 클래스 변경?, 위치 변경 필요함
    public static List<Integer> parseNumbers(List<String> userInputs) {
        List<Integer> inputNumber = new ArrayList<>();

        for (String userInput : userInputs) {
            checkLotto(userInput);
            inputNumber.add(Integer.parseInt(userInput));
        }

        return inputNumber;
    }

    public static void checkLotto(String userInput) {
        Validator.checkNumber(userInput);
        Validator.checkZero(userInput);
        Validator.checkRange(Integer.parseInt(userInput));
    }

    public static List<String> split(String userInput) {
        return Arrays.asList(Computer.getInput().split(","));
    }
}
