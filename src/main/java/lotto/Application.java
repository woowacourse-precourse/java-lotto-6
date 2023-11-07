package lotto;

import dto.WinningNumberDTO;
import ui.IOView;

public class Application {
    public static void main(String[] args) {

        int money = IOView.getMoney();
        LottoTickets lottoTickets = LottoTickets.buy(money);
        IOView.printLottoNumbers(lottoTickets);

        WinningNumberDTO winningNumbers = IOView.getWinningNumbers();
        LottoPrizeBag prizeBag = lottoTickets.matchPrize(winningNumbers);
        IOView.printPrizes(prizeBag);
    }
}
