package lotto.view.inputview;

import camp.nextstep.edu.missionutils.Console;
import java.util.function.Function;
import lotto.domain.lotto.WinningNumbers;

public class InputView {

    public static Object inputValue(InputValueType inputValueType) {
        while (true) {
            try {
                System.out.println(inputValueType.getMessage());

                Function<String, Object> createFunction = inputValueType.getCreateFunction(null);
                String input = Console.readLine();

                return createFunction.apply(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    public static Object inputValue(InputValueType inputValueType, Object requiredObject) {
        while (true) {
            try {
                System.out.println(inputValueType.getMessage());

                Function<String, Object> createFunction = inputValueType.getCreateFunction(requiredObject);
                String input = Console.readLine();

                return createFunction.apply(input);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
