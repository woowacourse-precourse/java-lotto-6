package lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class WinningNumber {
    private List<Integer> winningNumbers= new ArrayList<>();

    public void setWinningNumbers() {
        System.out.println();
        System.out.println("당첨 번호를 입력해 주세요.");
        inputWinningNumbers();
    }

    private void inputWinningNumbers() {
        List<String> winningNumbersInput = Arrays.asList(Console.readLine().split(","));
        //validate
        for (int i = 0; i < 6; i++) {
            winningNumbers.add(Integer.parseInt(winningNumbersInput.get(i)));
        }
    }

    private void printWinningNumbers() {
        for (int i = 0; i < 5; i++) {
            System.out.printf(winningNumbers.get(i) + ",");
        }
        System.out.printf(winningNumbers.get(5).toString());
    }

    public void parseWinningNumbers(List<String> winningNumbers) {
        for (int i = 0; i < 6; i++) {
            this.winningNumbers.add(Integer.parseInt(winningNumbers.get(i)));
        }
    }


    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

}
