package lotto;

import dto.WinningNumberDTO;
import ui.IOView;

public class Application {
    public static void main(String[] args) {

        int money = IOView.getMoney();
        LottoTickets lottoTickets = LottoTickets.buy(money);
        IOView.printLottoNumbers(lottoTickets);

        WinningNumberDTO winningNumbers = IOView.getWinningNumbers();
        lottoTickets.matchPrize(winningNumbers);

        // TODO: 프로그램 구현
    }
}
