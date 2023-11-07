package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {

    public Integer getNumber(){
        String input = Console.readLine();

        return Integer.parseInt(input);
    }

    public List<Integer> getNumbers(){
        String numbers = Console.readLine();
        String[] numberArr = numbers.split(",");

        return Arrays.stream(numberArr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

}
