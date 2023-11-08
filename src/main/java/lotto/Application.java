package lotto;

import ui.IOView;

public class Application {
    public static void main(String[] args) {

        LottoMoney money = IOView.getMoney();
        LottoTickets lottoTickets = LottoTickets.buy(money);
        IOView.printLottoNumbers(lottoTickets);

        LottoWinningNumber winningNumbers = IOView.getWinningNumbers();
        LottoPrizeBag prizeBag = lottoTickets.matchPrize(winningNumbers);
        IOView.printPrizes(prizeBag);
    }
}
