package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.controller.exception.DuplicationException;
import lotto.controller.exception.RangeException;
import lotto.controller.exception.WrongTypeException;

public class InputWinningNumbers {
    private static final String MESSAGE = "당첨 번호를 입력해 주세요.";

    public List<Integer> getWinningNumbers() {
        System.out.println(MESSAGE);
        while (true) {
            String winningNumbers = Console.readLine();
            System.out.println();
            try {
                validation(winningNumbers);
                return winningNumberConvertor(winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validation(String winningNumbers) {
        winningNumbersValidation(winningNumbers);
    }

    private void winningNumbersValidation(String winningNumbers) {
        if (!Pattern.compile("(\\d{1,2},){5}\\d{1,2}").matcher(winningNumbers).matches()) {
            throw new WrongTypeException();
        }
        List<Integer> numbers = new ArrayList<>(winningNumberConvertor(winningNumbers));
        Set<Integer> checkNumbers = new HashSet<>(numbers);
        if (checkNumbers.size() != 6) {
            throw new DuplicationException();
        }
        numbers.forEach(this::rangeValidation);
    }

    private void rangeValidation(Integer number) {
        if (number < 1 || number > 45) {
            throw new RangeException();
        }
    }

    private List<Integer> winningNumberConvertor(String winningNumbers) {
        return Stream.of(winningNumbers.split(","))
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

}
