package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class InputController {

    private static final String COMMA_DELIMITER = ",";

    private static final String NUMBER = "^[0-9]*$";


    public int inputPurchasePrice() {
        return Integer.parseInt(Console.readLine());
    }

    public List<Integer> inputLottoNumbers() {
        String[] inputValue = Console.readLine().split(COMMA_DELIMITER);
        List<Integer> winningNumber = new ArrayList<>();
        for (String value : inputValue) {
            winningNumber.add(Integer.parseInt(value));
        }
        return winningNumber;
    }

    public int inputBonusNumber() {
        String bonusNumber = Console.readLine();
        validateInputDataIsNumber(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }

    public void validateInputDataIsNumber(String inputData) {
        if (!Pattern.matches(NUMBER, inputData)) {
            throw new IllegalArgumentException("로또 번호는 숫자만 입력 가능합니다.");
        }
    }
}
