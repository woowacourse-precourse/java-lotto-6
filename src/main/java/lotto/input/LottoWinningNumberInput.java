package lotto.input;

import static lotto.constant.Constant.BOUNS_NUMBER_INPUPT_MESSAGE;
import static lotto.constant.Constant.WINNING_NUMBER_INPUT_MESSAGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import lotto.Validator.WinningNumberInputValidate;

public class LottoWinningNumberInput {
    List<Integer> winningNumbers = new ArrayList<>();
    private final WinningNumberInputValidate validator = new WinningNumberInputValidate();


    public List<Integer> createWinningNumbers() {
        winningNumberInput();
        bounsNumberInput();
        return winningNumbers;
    }

    public void winningNumberInput() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
                List<String> values = splitInput(Console.readLine());
                winningNumbersValidateCheck(values);
                break;
            } catch (IllegalArgumentException e) {
                winningNumbers.clear();
                System.out.println(e.getMessage());
            }
        }
    }

    private void bounsNumberInput() {
        while (true) {
            try {
                System.out.println(BOUNS_NUMBER_INPUPT_MESSAGE);
                String value = Console.readLine();
                bounsValidateCheck(value);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    public void winningNumbersValidateCheck(List<String> values) {
        validator.valueSizeValidate(values);
        for (String value : values) {
            integratedValidateCheck(value);
        }
        Collections.sort(winningNumbers);
    }


    private void bounsValidateCheck(String value) {
        integratedValidateCheck(value);
    }

    private void integratedValidateCheck(String value) {
        int number;
        number = validator.isNumberValidate(value);
        validator.scopeValidate(number);
        validator.isDuplicateValidate(number, winningNumbers);
    }


}
