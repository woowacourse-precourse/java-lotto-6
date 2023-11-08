package lotto.domain;

import java.util.Arrays;
import java.util.stream.Collectors;

import lotto.util.InputUtil;

public class LottoWinningNumber {
    private Lotto winningNumber;
    private int bonusNumber;

    public void createWinningNumber() {
        String[] winningNumber = InputUtil.getInput().split(",");
        this.winningNumber = new Lotto(
            Arrays.stream(winningNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList())
        );  
    }

    public void createBonusNumber() {
        this.bonusNumber = Integer.parseInt(InputUtil.getInput());
    }
    
    public Lotto getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
