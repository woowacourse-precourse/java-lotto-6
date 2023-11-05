package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;

import java.util.ArrayList;
import java.util.List;

public class InputMaker {
    private static Console console;

    public static String userInput(){
        String userInput = console.readLine();
        console.close();
        return userInput;
    }

    public int inputNum(String userInput) {
        try {
            int coin = Integer.parseInt(userInput);
            return coin;
        } catch(Exception e) {
            throw new IllegalArgumentException("[ERROR] 숫자를 입력해주세요.");
        }
    }

    public Lotto inputWinningNumber(String userInput) {
        String[] inputNumber = userInput.split(",");
        List<Integer> winningNum= new ArrayList<>();
        for (int i = 0; i<inputNumber.length; i++) {
            winningNum.set(i,inputNum((inputNumber[i])));
        }
        Lotto winnerNumber = new Lotto(winningNum);
        return winnerNumber;
    }
}
