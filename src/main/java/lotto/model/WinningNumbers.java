package lotto.model;

import java.util.List;

public class WinningNumbers {
    private static WinningNumbers instance;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    private WinningNumbers(List<Integer> userWinningNumbers, int userBonusNumber) {
        this.winningNumbers = userWinningNumbers;
        this.bonusNumber = userBonusNumber;
    }

    //싱글톤 패턴
    public static WinningNumbers getInstance(List<Integer> userWinningNumbers, int userBonusNumber) {
        if (instance == null) {
            instance = new WinningNumbers(userWinningNumbers, userBonusNumber);
        }
        return instance;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
