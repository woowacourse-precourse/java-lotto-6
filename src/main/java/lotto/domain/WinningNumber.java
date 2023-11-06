package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {

    private List<Integer> winningNumber;
    private String inputWinningNumber;
    private String[] numbers;

    public WinningNumber(String inputWinningNumber) {
        this.inputWinningNumber = validateInputWinningNumber(inputWinningNumber);
        winningNumber = new ArrayList<>();
        setWinningNumberList(this.inputWinningNumber);
    }



    private String validateInputWinningNumber(String inputWinningNumber) {
        // 당첨번호가 ","로 구분되어지는가

        // 당첨번호가 숫자로 되어있는가

        // 당첨번호가 1~45사이의 숫자인가

        // 당첨번호에 중복이 있는가

       return inputWinningNumber;
    }

    private void setWinningNumberList(String inputWinningNumber) {
        numbers = inputWinningNumber.split(",");
        for (String number : numbers) {
            int num = Integer.parseInt(number);
            winningNumber.add(num);
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
