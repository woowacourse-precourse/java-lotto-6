package lotto.domain;

import java.util.List;

public class Calculator {

    private final List<Integer> winningLottos;
    private final int money;

    public Calculator(List<Integer> winningLottos, int money) {
        this.winningLottos = winningLottos;
        this.money = money;
    }

    public double calculateProfitRate() {
        int sum = 0;
        if(winningLottos.get(0) > 0) {
            sum = sum + winningLottos.get(0) * 2000000000;
        }
        if(winningLottos.get(1) > 0) {
            sum = sum + winningLottos.get(1) * 30000000;
        }
        if(winningLottos.get(2) > 0) {
            sum = sum + winningLottos.get(2) * 1500000;
        }
        if(winningLottos.get(3) > 0) {
            sum = sum + winningLottos.get(3) * 50000;
        }
        if(winningLottos.get(4) > 0) {
            sum = sum + winningLottos.get(4) * 5000;
        }
        return (double) sum / money * 100;
    }
}
