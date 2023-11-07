package lotto;

import dto.LottoMoney;
import ui.ExceptionHandler;
import ui.IOView;

public class Application {
    public static void main(String[] args) {
        setExceptionHandler();

        LottoMoney money = IOView.getMoney();
        LottoTickets lottoTickets = LotteryMachine.buy(money);
        IOView.printLottoNumbers(lottoTickets);
        // TODO: 프로그램 구현
    }

    private static void setExceptionHandler() {
        ExceptionHandler exceptionHandler = new ExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(exceptionHandler);
    }
}
