package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public Integer inputIntegerWithMessgae(Script script) {
        System.out.println(script.label());
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputIntegerListWithMessage(Script script) {
        System.out.println(script.label());
        return Arrays.stream(Console.readLine().split(","))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }
}
