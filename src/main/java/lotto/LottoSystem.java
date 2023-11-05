package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lotto.calculator.MoneyCalculator;
import lotto.exception.LottoApplicationException;
import lotto.exception.ExceptionHandler;
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
    private final ExceptionHandler exceptionHandler;

    public LottoSystem(MoneyCalculator moneyCalculator, NumberGenerator numberGenerator,
                       TicketScratcher ticketScratcher, OutputManager outputManager,
                       ExceptionHandler exceptionHandler) {
        this.moneyCalculator = moneyCalculator;
        this.numberGenerator = numberGenerator;
        this.ticketScratcher = ticketScratcher;
        this.outputManager = outputManager;
        this.exceptionHandler = exceptionHandler;
    }

    public void run() {
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
                exceptionHandler.handleException(e);
            }
        }
    }

    private BigDecimal calculate(Integer amountToQuantity, ScratchedLottoTicketList scratchedLottoTicketList) {
        while (true) {
            try {
                moneyCalculator.calculate(scratchedLottoTicketList, amountToQuantity);
                return moneyCalculator.getRateOfReturn();
            } catch (LottoApplicationException e) {
                exceptionHandler.handleException(e);
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
                exceptionHandler.handleException(e);
            }
        }
    }

    private WinningNumbers chooseWinningNumber() {
        while (true) {
            try {
                String unprocessedWinningNumbers = this.readLine();
                List<Integer> winningNumbersFromConsole = numberGenerator.createWinningNumbersFromConsole(
                        unprocessedWinningNumbers);
                return new WinningNumbers(winningNumbersFromConsole);
            } catch (LottoApplicationException e) {
                exceptionHandler.handleException(e);
            }
        }
    }

    private List<LottoTicket> saveLottoTickets(Integer amountToQuantity) {
        while (true) {
            try {
                List<LottoTicket> lottoTickets = new ArrayList<>();
                for (int i = 0; i < amountToQuantity; i++) {
                    List<Integer> randomUniqueNumber = numberGenerator.createRandomUniqueNumber();
                    LottoTicket lottoTicket = new LottoTicket(randomUniqueNumber);
                    outputManager.printOneLottoTicketAnnounce(lottoTicket);
                    lottoTickets.add(lottoTicket);
                }
                return lottoTickets;
            } catch (LottoApplicationException e) {
                exceptionHandler.handleException(e);
            }
        }
    }

    private String readLine() {
        return Console.readLine();
    }

    private void close() {
        Console.close();
    }
}
