package lotto.mapper;

import lotto.constant.ErrorMessage;

import java.util.Arrays;
import java.util.List;

public class Mapper {

    public List<Integer> stringToIntegerList(String userInput) {
        try {
            return Arrays.stream(userInput.split(","))
                    .map(Integer::parseInt)
                    .sorted()
                    .toList();
        } catch (Exception e) {
            throw new IllegalArgumentException(ErrorMessage.INCORRECT_INPUT.toMessage());
        }
    }
}
