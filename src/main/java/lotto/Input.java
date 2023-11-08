package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.Validate.InputValidate;
import lotto.Validate.Validate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {
    Validate validate;

    Input() {
        validate = new InputValidate();
    }

    public Integer inputIntegerWithMessage(Script script) {
        System.out.println(script.label());
        String input = Console.readLine();
        try {
            Integer.parseInt(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            Error.PARSETOINTEGER.print();
            return inputIntegerWithMessage(script);
        }
        return Integer.parseInt(input);
    }

    public List<Integer> inputIntegerListWithMessage(Script script) {
        System.out.println(script.label());
//        String input = Console.readLine();
        return Arrays.stream(Console.readLine().split(","))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }
}
