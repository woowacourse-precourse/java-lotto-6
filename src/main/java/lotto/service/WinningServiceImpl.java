package lotto.service;

import java.util.List;
import lotto.domain.WinningNumber;

public class WinningServiceImpl implements WinningService {

    private WinningNumber winningNumber;

    public WinningServiceImpl() {
        this.winningNumber = new WinningNumber();
    }

    @Override
    public void createWinningLotto(List<Integer> winningNumbers) {
        winningNumber.createWinningNumber(winningNumbers);
    }
}
