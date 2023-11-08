package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.util.InputUtil;
import lotto.util.ValidationUtil;

public class LottoWinningNumber {
    private Lotto winningNumber;
    private int bonusNumber;

    public void createWinningNumber() {
        String[] winningNumber = InputUtil.getInput().split(",");
        try {
            winningNumber = ValidationUtil.validateLottoNumber(winningNumber);
            this.winningNumber = new Lotto(Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createWinningNumber();
        }
    }

    public void createBonusNumber(Lotto winningNumber) {
        try {
            this.bonusNumber = ValidationUtil.validateBonusNumber(InputUtil.getInput(), winningNumber.getNumbers());    
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            createBonusNumber(winningNumber);
        }
    }
    
    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
