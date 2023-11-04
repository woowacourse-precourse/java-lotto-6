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

    // 자료형 조작
    public static List<Integer> parseNumbers(List<String> userInputs) {
        List<Integer> inputNumber = new ArrayList<>();

        for (String userInput : userInputs) {
            Validator.checkNumber(userInput);
            Validator.checkZero(userInput);

            Integer lottoNumber = Integer.parseInt(userInput);
            Validator.checkRange(lottoNumber);

            inputNumber.add(Integer.parseInt(userInput));
        }

        return inputNumber;
    }

    public static List<String> split(String userInput) {
        return Arrays.asList(Computer.getInput().split(","));
    }
}
