package view;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class LottoWinningNumberInputView {
    public List<Integer> readLottoWinningNumber() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String winnnigLottoNumber = Console.readLine();
        List<Integer> winningNumbers = new ArrayList<>();
        for (String winningNumber: winnnigLottoNumber.split(",")) {
            winningNumbers.add(Integer.parseInt(winningNumber));
        }
        return winningNumbers;
    }
}