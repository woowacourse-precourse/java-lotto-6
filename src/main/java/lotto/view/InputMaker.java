package lotto.view;

import java.util.ArrayList;
import java.util.List;

public class InputMaker {

    public int inputNum(String userInput) {
        try {
            int coin = Integer.parseInt(userInput);
            return coin;
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public List<Integer> inputWinningNumber(String userInput) {
        List<Integer> result = new ArrayList<>();
        String[] inputNumber = userInput.split(",");
        for (int i = 0; i<inputNumber.length; i++) {
            result.add(inputNum(inputNumber[i]));
        }
        return result;
    }
}
