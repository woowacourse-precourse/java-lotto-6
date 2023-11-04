package lotto.input.view.input;

import static lotto.input.constant.Constant.BOUNS_NUMBER_INPUPT_MESSAGE;
import static lotto.input.constant.Constant.DUPLICATE_ERROR;
import static lotto.input.constant.Constant.LOTTO_NUMBER_SIZE;
import static lotto.input.constant.Constant.NOT_NUMBER_ERROR;
import static lotto.input.constant.Constant.NUMBER_SCOPE_ERROR;
import static lotto.input.constant.Constant.WINNING_NUMBER_INPUT_MESSAGE;
import static lotto.input.constant.Constant.WINNING_NUMBER_SIZE_ERROER;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LottoWinningNumberInput {
    List<Integer> winningNumbers = new ArrayList<>();

    public LottoWinningNumberInput() {
    }

    public List<Integer> createWinningNumber() {
        while (true) {
            try {
                System.out.println(WINNING_NUMBER_INPUT_MESSAGE);
                List<String> values = splitInput(Console.readLine());
                winningNumbersValidateCheck(values);
                System.out.println(BOUNS_NUMBER_INPUPT_MESSAGE);
                String value = Console.readLine();
                bounsValidate(value);
                System.out.println("winningNumbers = " + winningNumbers);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                winningNumbers.clear();
            }
        }
        return winningNumbers;
    }

    public List<String> splitInput(String input) {
        return Arrays.asList(input.split(","));
    }

    public void winningNumbersValidateCheck(List<String> values) {
        valueSizeValidate(values);
        for (String value : values) {
            extracted(value);
        }
        Collections.sort(winningNumbers);
    }

    public void valueSizeValidate(List<String> values) {
        if (values.size() != LOTTO_NUMBER_SIZE) {
            throw new IllegalArgumentException(WINNING_NUMBER_SIZE_ERROER);
        }
    }

//    private void winningValidate(String value) {
//        try {
//            extracted(value);
//        } catch (IllegalArgumentException e) {
//            System.out.println("[ERROR] : 1~45 사이의 중복 되지 않는 숫자 6개를 입력해야 합니다.");
//        }
//    }

    private void bounsValidate(String value) {
        extracted(value);
    }

    private void extracted(String value) {
        int number;
        number = isNumberValidate(value);
        scopeValidate(number);
        isDuplicateValidate(number);
    }

    public Integer isNumberValidate(String value) {
        int number;
        try {
            number = Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_NUMBER_ERROR);
        }
        return number;
    }

    public void scopeValidate(Integer value) {
        if (value > 45 || value < 1) {
            throw new IllegalArgumentException(NUMBER_SCOPE_ERROR);
        }
    }

    public void isDuplicateValidate(Integer value) {
        if (winningNumbers.contains(value)) {
            winningNumbers.clear();
            throw new IllegalArgumentException(DUPLICATE_ERROR);
        }
        winningNumbers.add(value);
    }

}
