package lotto.core;

import camp.nextstep.edu.missionutils.Console;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
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
        try {
            outputManager.printPurchaseAmountAsk();
            Integer amountToQuantity = chooseAmount();
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
        } finally {
            this.close();
        }
    }

    private Integer chooseAmount() {
        return this.getInputAndCatchException(numberGenerator::createAmountToQuantity,
                exceptionOutputManager::printException);
    }

    private BigDecimal calculate(Integer amountToQuantity, ScratchedLottoTicketList scratchedLottoTicketList) {
        moneyCalculator.calculate(scratchedLottoTicketList, amountToQuantity);
        return moneyCalculator.getRateOfReturn();
    }

    private BonusNumber chooseBonusNumber() {
        Integer bonusNumberFormConsole = this.getInputAndCatchException(numberGenerator::createBonusNumberFromConsole,
                exceptionOutputManager::printException);
        return new BonusNumber(bonusNumberFormConsole);
    }

    private WinningNumbers chooseWinningNumber() {
        return this.getInputAndCatchException(numberGenerator::createWinningNumbersFromConsole,
                exceptionOutputManager::printException);
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

    private <T> T getInputAndCatchException(Function<String, T> processor,
                                            Consumer<LottoApplicationException> exceptionHandler) {
        while (true) {
            try {
                String input = this.readLine();
                return processor.apply(input);
            } catch (LottoApplicationException e) {
                exceptionHandler.accept(e);
            }
        }
    }
}
