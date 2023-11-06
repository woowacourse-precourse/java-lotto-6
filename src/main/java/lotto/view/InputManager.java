package lotto.view;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputManager {
    public String readData() {
        return readLine();
    }
    public int getPurchaseAmount(String data) {
        //예외처리
        return Integer.parseInt(data)/1000;
    }
    public List<Integer> getWinningNumbers(String data) {
        //예외처리
        String[] splitNumbers = data.split(",");
        List<Integer> winningNumbers = new ArrayList<>();
        for(String number : splitNumbers) {
            winningNumbers.add(Integer.parseInt(number));
        }
        return winningNumbers;
    }
    public int getBonusNumber(String data) {
        //예외처리
        return Integer.parseInt(data);
    }
}
