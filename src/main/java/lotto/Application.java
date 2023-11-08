package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {

        // 로또 구입 금액 입력 받은 후, 발행 받기
        LottoMachine.receivingMoney();
        LottoMachine.givingLottoTickets();
        LottoMachine.printingLottoTickets();

        // 당첨 번호와 보너스 번호 입력 받기
        WinningLotto.gettingWinningNumbers();
        WinningLotto.gettingBonusNumber();

        // 통계 계산 후 수익률 출력
        ProfitCalculator.calculate();
        ProfitCalculator.calculateProfit();
        ProfitCalculator.printResult();
    }
}
