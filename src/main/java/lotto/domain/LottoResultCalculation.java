package lotto.domain;

import lotto.type.ErrorMessageType;

import java.util.List;
import java.util.regex.Pattern;

public class LottoResultCalculation {
    private int inputMoney;

    public LottoResultCalculation() {
        this.inputMoney = 0;
    }

    // 구입한 티켓의 수를 계산
    public int caculateLottoTicket(String money) throws IllegalArgumentException {
        this.inputMoney = inputMoneyException(money);
        int ticket = this.inputMoney / 1000;
        return ticket;
    }

    // 입력된 돈에 대한 예외 처리
    public int inputMoneyException(String money) throws IllegalArgumentException {
        if (!Pattern.matches("^[1-9][0-9]*$", money)) {
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

    // 동일한 숫자의 개수를 반환
    public int checkResult(List<Integer> target, List<Integer> tryLotto) {
        int result = (int) tryLotto.stream()
                .filter(target::contains)
                .count();

        return result;
    }

    // 보너스 숫자와 같은 수가 있는지 확인
    public boolean checkBonusNumber(List<Integer> target, int bonus) {
        boolean result = target.contains(bonus);
        return result;
    }

    // 총 수익률 계산
    public double calculateReturn(int totalWinningMoney) {
        double result = (double) totalWinningMoney / inputMoney;
        return Math.round((result * 1000)) / 1000.0 * 100;
    }
}
