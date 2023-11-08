package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    Input() {
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
        System.out.println();
        return Integer.parseInt(input);
    }

    public List<Integer> inputIntegerListWithMessage(Script script) {
        System.out.println(script.label());
        String input = Console.readLine();
        try {
            stringToIntegerList(input);
        } catch (IllegalArgumentException illegalArgumentException) {
            Error.PARSETOINTEGER.print();
            return inputIntegerListWithMessage(script);
        }
        System.out.println();
        return stringToIntegerList(input);
    }

    private List<Integer> stringToIntegerList(String string) {
        return Arrays.stream(string.split(","))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }
}
