package lotto.domain;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WinningManager {
    private final List<Integer> winningNumber;

    private final int bonusNumber;

    private int winningMoney;

    private double winningRate;

    public WinningManager(final List<Integer> winningNumber, final int bonusNumber) {
        this.winningNumber = winningNumber;
        this.bonusNumber = bonusNumber;
        this.winningMoney = 0;
    }

    public void calculateWinningRate(HashMap lotto,int lottoAmount){
        for(int i=3; i<=7; i++){
            if(lotto.get(i) != null) {
                if (i == 3) {
                    winningMoney += ((int)lotto.get(i) * 5000);
                }
                if (i == 4) {
                    winningMoney += ((int)lotto.get(i) * 50000);
                }
                if (i == 5) {
                    winningMoney += ((int)lotto.get(i) * 1500000);
                }
                if (i == 6) {
                    winningMoney += ((int)lotto.get(i) * 2000000000);
                }
                if (i == 7) {
                    winningMoney += ((int)lotto.get(i) * 30000000);
                }
            }
        }

        this.winningRate = ((double)winningMoney / (double)(lottoAmount*1000)) * 100;
//        System.out.println(winningMoney);
//        System.out.printf("%.1f",winningRate);
    }

    public List<Integer> getWinningNumber() {
        return winningNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
    public int getWinningMoney() {
        return winningMoney;
    }

    public double getWinningRate() {
        return winningRate;
    }
}
