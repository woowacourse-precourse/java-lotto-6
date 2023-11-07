package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumber {
    private List<Integer> winningNumber;

    public WinningNumber(String inputWinning) {
        winningNumber = new ArrayList<>();
        isRightFormat(inputWinning);
        setWinningNumber(inputWinning);
    }

    public void isRightFormat(String inputWinning) {
        for (String s : inputWinning.split(",")) {
            isInteger(s);
        }
    }

    public void isInteger(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) < '0' || input.charAt(i) > '9') {
                System.out.println("[ERROR] 숫자만 입력해주시기 바랍니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    public void setWinningNumber(String inputWinning) {
        for (String s : inputWinning.split(",")) {
            winningNumber.add(Integer.parseInt(s));
        }
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }
}
