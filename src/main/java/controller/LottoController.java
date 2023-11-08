package controller;

import domain.BonusNumber;
import domain.LottoTicketsGeneratingMachine;
import domain.LottoTicketsPurchasingMachine;
import domain.LottoWinningNumbers;
import domain.LottoWinningStatistics;
import domain.LottoWinningTier;
import domain.TicketSize;
import domain.WinningNumbers;
import dto.Bill;
import dto.LottoStatisticsResult;
import dto.LottoTickets;
import exception.CustomException;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;
import view.View;

public class LottoController {
    private final LottoTicketsPurchasingMachine lottoTicketsPurchasingMachine = new LottoTicketsPurchasingMachine();
    private final LottoTicketsGeneratingMachine lottoTicketsGeneratingMachine = new LottoTicketsGeneratingMachine();
    private final LottoWinningStatistics lottoWinningStatistics = new LottoWinningStatistics();
    private final View view;

    public LottoController(View view) {
        this.view = view;
    }

    public void tryLottoSimulation() {
        Bill bill = repeatWhenEnterCorrectAnswer(this::purchaseOfLottoTickets);
        LottoTickets lottoTickets = buyLottoTickets(bill.getTicketSize());
        LottoWinningNumbers lottoWinningNumbers = repeatWhenEnterCorrectAnswer(this::createLottoWinningNumbers);
        List<LottoWinningTier> tiers = lottoWinningNumbers.calculateWinningStatistics(lottoTickets);
        LottoStatisticsResult lottoStatisticsResult = lottoWinningStatistics.calculateStatistics(bill.getAmount(),
                tiers);
        view.showLottoStatisticsResult(lottoStatisticsResult);
    }

    private Bill purchaseOfLottoTickets() {
        int purchaseAmount = view.requirePurchaseAmount();
        return lottoTicketsPurchasingMachine.purchaseOfLottoTickets(purchaseAmount);
    }

    private LottoTickets buyLottoTickets(TicketSize ticketSize) {
        LottoTickets lottoTickets = lottoTicketsGeneratingMachine.generateRandomLottoTickets(ticketSize);
        view.showLottoTickets(lottoTickets);
        return lottoTickets;
    }

    private LottoWinningNumbers createLottoWinningNumbers() {
        WinningNumbers winningNumbers = repeatWhenEnterCorrectAnswer(this::createWinningNumbers);
        BonusNumber bonusNumber = repeatWhenEnterCorrectAnswer(() -> createBonusNumber(winningNumbers));
        return LottoWinningNumbers.createWinningNumbers(winningNumbers, bonusNumber);
    }

    private WinningNumbers createWinningNumbers() {
        List<Integer> numbers = view.requireLottoWinningNumbers();
        return WinningNumbers.createWinningNumbers(numbers);
    }

    private BonusNumber createBonusNumber(WinningNumbers winningNumbers) {
        int number = view.requireBonusLottoNumber();
        BonusNumber bonusNumber = BonusNumber.createBonusNumber(number);
        bonusNumber.exceptionIfDuplicate(winningNumbers);
        return bonusNumber;
    }

    private <T> T repeatWhenEnterCorrectAnswer(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (CustomException customException) {
                view.showExceptionMessage(customException.getMessage());
            }
        }
    }
}
