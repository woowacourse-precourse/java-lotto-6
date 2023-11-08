package lotto.service;

import static lotto.exception.ErrorMessage.ERROR_MESSAGE;
import static lotto.exception.ErrorMessage.INPUT_CONTAIN_NOT_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_DUPLICATED_NUMBER;
import static lotto.exception.ErrorMessage.LOTTO_NUMBER_RANGE_OVER;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

public class InputService {

    public Integer getNumber() {
        String input = Console.readLine();
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            System.out.println(ERROR_MESSAGE.getValue() + INPUT_CONTAIN_NOT_NUMBER.getValue());
            getNumber();
        }

        return null;
    }

    public List<Integer> getNumbers(){
        String numbers = Console.readLine();
        String[] numberArr = numbers.split(",");

        if (numberArr.length != 6) {
            throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTO_NUMBER_RANGE_OVER.getValue());
        }

        HashSet<Integer> uniqueNumbers = new HashSet<>();
        for (String numberStr : numberArr) {
            int number = Integer.parseInt(numberStr);
            if (!uniqueNumbers.add(number)) {
                throw new IllegalArgumentException(ERROR_MESSAGE.getValue() + LOTTO_DUPLICATED_NUMBER.getValue());
            }
        }

        return Arrays.stream(numberArr)
                .map(Integer::parseInt)
                .collect(Collectors.toList());

    }

}
