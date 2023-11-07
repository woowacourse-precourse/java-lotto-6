package lotto;

import dto.LottoMoneyDTO;
import dto.WinningNumberDTO;
import ui.IOView;

public class Application {
    public static void main(String[] args) {

        LottoMoneyDTO money = IOView.getMoney();
        LottoTickets lottoTickets = LotteryMachine.buy(money);
        IOView.printLottoNumbers(lottoTickets);
        WinningNumberDTO winningNumbers = IOView.getWinningNumbers();
        LotteryMachine.draw(winningNumbers);
        // TODO: 프로그램 구현
    }
}
