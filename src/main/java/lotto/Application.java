package lotto;

import dto.MoneyDTO;
import dto.WinningNumberDTO;
import ui.IOView;

public class Application {
    public static void main(String[] args) {

        MoneyDTO money = IOView.getMoney();
        LottoTickets lottoTickets = LottoTickets.buy(money.getMoney());
        IOView.printLottoNumbers(lottoTickets);

        WinningNumberDTO winningNumbers = IOView.getWinningNumbers();
        lottoTickets.matchPrize(winningNumbers);

        // TODO: 프로그램 구현
    }
}
