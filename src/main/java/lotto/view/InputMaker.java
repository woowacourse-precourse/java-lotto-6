package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputMaker {

    public int inputNum(String userInput) {
        try {
            return Integer.parseInt(userInput.trim());
        } catch (NumberFormatException e) {
            System.err.println("[ERROR] 유효하지 않은 숫자입니다.");
            return -1;
        }
    }

    public void inputCoinValidate(int coin) {
        if (coin % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입금액은 1000단위만 허용합니다.");
        }
    }

    public List<Integer> inputWinningNumber(String userInput) {
        List<Integer> result = new ArrayList<>();
        String[] inputNumber = userInput.split(",");
        for (int i = 0; i < inputNumber.length; i++) {
            result.add(inputNum(inputNumber[i].trim()));
        }
        return result;
    }
}
