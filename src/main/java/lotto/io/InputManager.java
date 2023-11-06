package lotto.io;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;

public class InputManager {

    public int readMoney() {
        String input = Console.readLine();
        validateInputMoneyFormat(input);

        int money = Integer.parseInt(input);
        validateInputMoneyUnit(money);

        return money;
    }

    public List<Integer> readWinningNumber() {
        String input = Console.readLine();
        String[] inputs = input.split(",");

        validateWinningNumberSize(inputs);
        validateWinningNumberFormat(inputs);
        validateInputNumberRange(inputs);

        return StringArrToIntegerList(inputs);
    }

    public int readInputBonusNumber() {
        String input = Console.readLine();

        validateInputBonusNumberFormat(input);
        validateInputNumberRange(input);

        return Integer.parseInt(input);
    }

    public void validateInputMoneyFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]+");

        if(!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }

    public void validateInputMoneyUnit(int money) {
        int remainder = money % 1000;

        if(remainder != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumberSize(String[] inputs) {
        if(inputs.length != 6) {
            throw new IllegalArgumentException();
        }
    }

    public void validateWinningNumberFormat(String[] inputs) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}");

        for(String input : inputs) {
            if(!pattern.matcher(input).matches()) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateInputNumberRange(String[] inputs) {
        for(String input : inputs) {
            int inputNumber = Integer.parseInt(input);

            if(inputNumber < 1 || inputNumber > 45) {
                throw new IllegalArgumentException();
            }
        }
    }

    public void validateInputNumberRange(String input) {
        int inputNumber = Integer.parseInt(input);

        if(inputNumber < 1 || inputNumber > 45) {
            throw new IllegalArgumentException();
        }
    }

    public List<Integer> StringArrToIntegerList(String[] inputs) {
        List<Integer> winningNumbers = new ArrayList<>();

        for(String input : inputs) {
            winningNumbers.add(Integer.parseInt(input));
        }

        return winningNumbers;
    }



    public void validateInputBonusNumberFormat(String input) {
        Pattern pattern = Pattern.compile("[0-9]{1,2}");

        if(!pattern.matcher(input).matches()) {
            throw new IllegalArgumentException();
        }
    }
}
