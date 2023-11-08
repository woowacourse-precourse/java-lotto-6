package lotto.domain;

import lotto.type.ErrorMessageType;

import java.util.List;

public class LottoResultCalculation {
    private int inputMoney;

    public LottoResultCalculation() {
        this.inputMoney = 0;
    }

    public int caculateLottoTicket(String money) throws IllegalArgumentException {
        this.inputMoney = inputMoneyException(money);
        int ticket = this.inputMoney / 1000;
        return ticket;
    }

    public int inputMoneyException(String money) throws IllegalArgumentException {
        if (money.matches("[0-9]+") == false) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_NUMBER.message());
        }
        int intMoney = Integer.parseInt(money);
        if (intMoney % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_DIVIDE_THOUSAND.message());
        }
        if (intMoney <= 0) {
            throw new IllegalArgumentException(ErrorMessageType.NOT_POSITIVE_NUMBER.message());
        }
        return intMoney;
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
