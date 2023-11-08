package lotto.Domain;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.Utils.InputSystem;

public class WinningNumbers {
    private final List<Integer> winningNumbers = new ArrayList<>();
    private int bonus;

    public Lotto setWinningNumbers(String[] texts) {
        return new Lotto(createWinningNumbers(texts));
    }

    private List<Integer> createWinningNumbers(String[] texts) {
        for (String text : texts) {
            winningNumbers.add(Integer.parseInt(text));
        }

        return winningNumbers;
    }

    public void setBonusNumber() {
        bonus = InputSystem.inputBonusNumber();
    }

    public int getBonusNumber() {
        return bonus;
    }
}
