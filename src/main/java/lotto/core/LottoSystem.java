package lotto.core;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.core.calculator.MoneyCalculator;
import lotto.core.exception.LottoApplicationException;
import lotto.core.iomanangers.ExceptionOutputManager;
import lotto.core.iomanangers.OutputManager;
import lotto.core.lotto.BonusNumber;
import lotto.core.lotto.LottoTicket;
import lotto.core.lotto.ScratchedLottoTicketList;
import lotto.core.lotto.TicketScratcher;
import lotto.core.lotto.WinningNumbers;
import lotto.core.numbergenerator.NumberGenerator;

public class LottoSystem {
    private final MoneyCalculator moneyCalculator;
    private final NumberGenerator numberGenerator;
    private final TicketScratcher ticketScratcher;
    private final OutputManager outputManager;
    private final ExceptionOutputManager exceptionOutputManager;

    public LottoSystem(MoneyCalculator moneyCalculator, NumberGenerator numberGenerator,
                       TicketScratcher ticketScratcher, OutputManager outputManager,
                       ExceptionOutputManager exceptionOutputManager) {
        this.moneyCalculator = moneyCalculator;
        this.numberGenerator = numberGenerator;
        this.ticketScratcher = ticketScratcher;
        this.outputManager = outputManager;
        this.exceptionOutputManager = exceptionOutputManager;
    }

    public void process() {
        outputManager.printPurchaseAmountAsk();
        Integer amountToQuantity = inputForAmount();
        outputManager.printQuantityAnnounce(amountToQuantity);
        List<LottoTicket> lottoTickets = saveLottoTickets(amountToQuantity);

        outputManager.printWinningNumberAsk();
        WinningNumbers winningNumbers = chooseWinningNumber();

        outputManager.printBonusNumberAsk();
        BonusNumber bonusNumber = chooseBonusNumber();

        ScratchedLottoTicketList scratchedLottoTicketList = ticketScratcher.scratchAllTickets(winningNumbers,
                bonusNumber, lottoTickets);
        outputManager.printWinningChartAnnounce(scratchedLottoTicketList);

        BigDecimal rateOfReturn = calculate(amountToQuantity, scratchedLottoTicketList);
        outputManager.printRateOfReturn(rateOfReturn);
        this.close();
    }

    private Integer inputForAmount() {
        while (true) {
            try {
                String purchaseAmount = this.readLine();
                return numberGenerator.createAmountToQuantity(purchaseAmount);
            } catch (LottoApplicationException e) {
                exceptionOutputManager.printException(e);
            }
        }
    }

    private BigDecimal calculate(Integer amountToQuantity, ScratchedLottoTicketList scratchedLottoTicketList) {
        while (true) {
            try {
                moneyCalculator.calculate(scratchedLottoTicketList, amountToQuantity);
                return moneyCalculator.getRateOfReturn();
            } catch (LottoApplicationException e) {
                exceptionOutputManager.printException(e);
            }
        }
    }

    private BonusNumber chooseBonusNumber() {
        while (true) {
            try {
                String unprocessedBonusNumber = this.readLine();
                Integer bonusNumberFromConsole = numberGenerator.createBonusNumberFromConsole(unprocessedBonusNumber);
                return new BonusNumber(bonusNumberFromConsole);
            } catch (LottoApplicationException e) {
                exceptionOutputManager.printException(e);
            }
        }
    }

    private WinningNumbers chooseWinningNumber() {
        while (true) {
            try {
                String unprocessedWinningNumbers = this.readLine();
                return numberGenerator.createWinningNumbersFromConsole(unprocessedWinningNumbers);
            } catch (LottoApplicationException e) {
                exceptionOutputManager.printException(e);
            }
        }
    }

    private List<LottoTicket> saveLottoTickets(Integer amountToQuantity) {
        List<LottoTicket> lottoTickets = new ArrayList<>();
        for (int i = 0; i < amountToQuantity; i++) {
            List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
            LottoTicket lottoTicket = new LottoTicket(randomUniqueNumber);
            outputManager.printOneLottoTicketAnnounce(lottoTicket);
            lottoTickets.add(lottoTicket);
        }
        return lottoTickets;
    }

    private String readLine() {
        return Console.readLine();
    }

    private void close() {
        Console.close();
    }
}
