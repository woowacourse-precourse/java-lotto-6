package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Input {

    public Integer inputIntegerWithMessgae(String message) {
        System.out.println(message);
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputIntegerListWithMessage(String message) {
        System.out.println(message);
        return Arrays.stream(Console.readLine().split(","))
                .map(x -> Integer.parseInt(x))
                .collect(Collectors.toList());
    }

}
