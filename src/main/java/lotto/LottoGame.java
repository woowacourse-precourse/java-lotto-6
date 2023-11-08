package lotto;

import lotto.console.InputConsole;
import lotto.model.Lotto;
import lotto.model.Capital;
import lotto.model.Player;
import lotto.model.WinningDetails;
import lotto.utils.LottoMachine;

public class LottoGame {

    void run() {
        Capital capital = InputConsole.getCapital();
        Player player = new Player(capital);

        System.out.println(player.getCapital().getNumberOfPurchasedLotto() + "개를 구매했습니다.");

        player.getLottos().forEach(System.out::println);

        Lotto winningNumbers = InputConsole.getWinningNumbers();
        int bonusNumber = InputConsole.getBonusNumber();

        LottoMachine lottoMachine = new LottoMachine(winningNumbers, bonusNumber);

        System.out.println("당첨 통계");
        System.out.println("---");

        WinningDetails winningDetails = player.getWinningDetails(lottoMachine);
        winningDetails.breakdown().forEach((lotteryRank, integer) -> {
            System.out.println(lotteryRank.getMessage() + " - " + integer + "개");
        });
        System.out.println("총 수익률은 " + winningDetails.returnOnInvestment() + "%입니다.");
    }


}
