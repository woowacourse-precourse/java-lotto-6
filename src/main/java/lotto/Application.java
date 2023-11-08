package lotto;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        LottoMachine.receivingMoney();
        LottoMachine.givingLottoTickets();
        LottoMachine.printingLottoTickets();

        WinningLotto.gettingWinningNumbers();
        WinningLotto.gettingBonusNumber();

        ProfitCalculator.determineRank();
        ProfitCalculator.calculateProfit();
        ProfitCalculator.printResult();
    }
}
