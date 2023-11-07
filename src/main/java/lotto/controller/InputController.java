package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.constant.ErrorMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputController {
    public Integer readInputByInteger() {
        try {
            return Integer.parseInt(Console.readLine().trim());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.NOT_A_NUMBER.getErrorMessage());
        }
    }

    public List<Integer> readInputByManyNumbers() {
        List<String> inputNumbers;
        List<Integer> winningNumbers = new ArrayList<>();

        inputNumbers = Arrays.stream(Console.readLine().replaceAll(" ", "").split(",")).toList();
        for (String inputNumber : inputNumbers) {
            winningNumbers.add(Integer.parseInt(inputNumber));
        }
        return winningNumbers;
    }
}
