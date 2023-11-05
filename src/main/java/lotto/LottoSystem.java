package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.IllegalFormatException;
import java.util.List;
import lotto.calculator.MoneyCalculator;
import lotto.exception.LottoApplicationException;
import lotto.iomanangers.OutputManager;
import lotto.lotto.BonusNumber;
import lotto.lotto.LottoTicket;
import lotto.lotto.ScratchedLottoTicketList;
import lotto.lotto.TicketScratcher;
import lotto.lotto.WinningNumbers;
import lotto.numbergenerator.NumberGenerator;

public class LottoSystem {
    private final MoneyCalculator moneyCalculator;
    private final NumberGenerator numberGenerator;
    private final TicketScratcher ticketScratcher;
    private final OutputManager outputManager;

    public LottoSystem(MoneyCalculator moneyCalculator,
                       NumberGenerator numberGenerator,
                       TicketScratcher ticketScratcher, OutputManager outputManager) {
        this.moneyCalculator = moneyCalculator;
        this.numberGenerator = numberGenerator;
        this.ticketScratcher = ticketScratcher;
        this.outputManager = outputManager;
    }

    public void run(){
        outputManager.printPurchaseAmountAsk();
        String purchaseAmount = this.readLine();
        Integer amountToQuantity = numberGenerator.createAmountToQuantity(purchaseAmount);
        outputManager.printQuantityAnnounce(amountToQuantity);

        List<LottoTicket> lottoTickets =new ArrayList<>();
        for(int i=0; i<amountToQuantity;i++){
            List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
            LottoTicket lottoTicket = new LottoTicket(randomUniqueNumber);
            outputManager.printOneLottoTicketAnnounce(lottoTicket);
            lottoTickets.add(lottoTicket);
        }

        outputManager.printWinningNumberAsk();
        String unprocessedWinningNumbers = this.readLine();
        List<Integer> winningNumbersFromConsole = numberGenerator.createWinningNumbersFromConsole(unprocessedWinningNumbers);
        WinningNumbers winningNumbers = new WinningNumbers(winningNumbersFromConsole);

        outputManager.printBonusNumberAsk();
        String unprocessedBonusNumber = this.readLine();
        Integer bonusNumberFromConsole = numberGenerator.createBonusNumberFromConsole(unprocessedBonusNumber);
        BonusNumber bonusNumber = new BonusNumber(bonusNumberFromConsole);

        ScratchedLottoTicketList scratchedLottoTicketList =
                ticketScratcher.scratchAllTickets(winningNumbers, bonusNumber, lottoTickets);

        outputManager.printWinningChartAnnounce(scratchedLottoTicketList);
        moneyCalculator.calculate(scratchedLottoTicketList,amountToQuantity);
        BigDecimal rateOfReturn = moneyCalculator.getRateOfReturn();
        outputManager.printRateOfReturn(rateOfReturn);
        this.close();
    }

    private String readLine(){
        return Console.readLine();
    }

    private void close(){
        Console.close();
    }
}
