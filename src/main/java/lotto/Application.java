package lotto;

import dto.LottoMoney;
import ui.IOView;

public class Application {
    public static void main(String[] args) {

        LottoMoney money = IOView.getMoney();
        LottoTickets lottoTickets = LotteryMachine.buy(money);
        IOView.printLottoNumbers(lottoTickets);
        // TODO: 프로그램 구현
    }
}
