package lotto.domain.WinningNumber;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;

public class WinningNumber {
    private List<Integer> winningNumbers= new ArrayList<>();
    private int bonusNumber;

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

    public void setBonusNumber() {
        System.out.println();
        System.out.println("보너스 번호를 입력해 주세요.");
        inputBonusNumber();
    }

    private void inputBonusNumber() {
        String bonusNumberInput = Console.readLine();
        //validate
        this.bonusNumber = Integer.parseInt(bonusNumberInput);
    }

    public List<Integer> getWinningNumbers() {
        return this.winningNumbers;
    }

    public int getBonusNumber() {
        return this.bonusNumber;
    }

}
