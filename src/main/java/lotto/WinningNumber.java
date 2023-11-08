package lotto;

import java.util.List;

public class WinningNumber {
    public final List<Integer> winNumber;
    public final int bonusNumber;

    public WinningNumber(List<Integer> winNumber, int bonusNumber) {
        this.winNumber = winNumber;
        this.bonusNumber = bonusNumber;
    }

    private void splitInput(String winInput) {
        if (winInput != null) {
            String[] ArrayStr = winInput.split(",");

            for (String s : ArrayStr) {
                winNumber.add(Integer.parseInt(s));
            }
        }
    }

    public List<Integer> getWinNumber() {
        return winNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
