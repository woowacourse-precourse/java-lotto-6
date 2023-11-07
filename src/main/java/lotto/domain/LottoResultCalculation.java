package lotto.domain;

import java.util.List;

public class LottoResultCalculation {
    private int inputMoney;

    public LottoResultCalculation() {
        this.inputMoney = 0;
    }

    public int caculateLottoTicket(int money) throws IllegalArgumentException {
        if(money % 1000 != 0) {
            throw new IllegalArgumentException();
        }
        this.inputMoney = money;
        int ticket = money / 1000;
        return ticket;
    }

    public int checkResult(List<Integer> target, List<Integer> tryLotto) {
        int result = (int) tryLotto.stream()
                .filter(target::contains)
                .count();

        return result;
    }

    public boolean checkBonusNumber(List<Integer> target, int bonus) {
        boolean result = target.contains(bonus);
        return result;
    }

    public double calculateReturn(int totalWinningMoney) {
        double result = (double) totalWinningMoney / inputMoney;
        return Math.round((result * 1000)) / 1000.0 * 100;
    }
}
