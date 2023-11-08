package lotto.lottosystem;

import lotto.lottosystem.bussiness.LottoService;
import lotto.lottosystem.bussiness.WoowahanLottoGenerator;
import lotto.lottosystem.presentation.printer.Printer;
import lotto.lottosystem.presentation.printer.StatisticsVO;
import lotto.lottosystem.presentation.printer.TicketsVO;
import lotto.lottosystem.presentation.reader.LottoNumbersVO;
import lotto.lottosystem.presentation.reader.MoneyVO;
import lotto.lottosystem.presentation.reader.Reader;
import lotto.lottosystem.presentation.reader.WoowahanConsole;

public class LottoSystem {
    public static void start() {
        Reader reader = new Reader(new WoowahanConsole());
        LottoService lottoService = new LottoService(new WoowahanLottoGenerator());

        MoneyVO moneyVO = reader.readMoney();
        TicketsVO ticketsVO = lottoService.issueTickets(moneyVO);
        Printer.printTickets(ticketsVO);

        LottoNumbersVO lottoNumbersVO = reader.readLottoNumbers();
        StatisticsVO statisticsVO = lottoService.calcStatistics(lottoNumbersVO, ticketsVO);
        Printer.printStatistics(statisticsVO);
    }
}
