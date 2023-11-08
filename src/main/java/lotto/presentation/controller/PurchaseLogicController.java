package lotto.presentation.controller;

import java.util.List;
import lotto.model.LottoTicket;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;

public class PurchaseLogicController {
    private View view;
    private Referee referee;
    private LottoTicketRepository ticketRepository;

    public PurchaseLogicController(View view, Referee referee, LottoTicketRepository ticketRepository) {
        this.view = view;
        this.referee = referee;
        this.ticketRepository = ticketRepository;
    }

    public void lottoPurchaseLogic() {
        int purchaseAmount = readAndValidateAmount();
        referee.generateLottoTickets(purchaseAmount);
        displayPurchaseResults();
    }

    private int readAndValidateAmount() {
        while (true) {
            view.promptForPurchaseAmount();
            String inputPurchaseAmount = LottoGameController.readAndRemoveSpace();
            try {
                getValidPurchaseAmount(inputPurchaseAmount);
                return parseInt(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                view.promptForError(e);
                view.promptForPurchaseAmount();
            }
        }
    }

    private int parseInt(String inputPurchaseAmount) {
        return Integer.parseInt(inputPurchaseAmount);
    }

    private void getValidPurchaseAmount(String inputPurchaseAmount) {
        LottoGameController.isNotBlankValue(inputPurchaseAmount);
        LottoGameController.isNotIntegerValue(inputPurchaseAmount);
        LottoTicket.isNotMultipleOfLottoPrice(Integer.parseInt(inputPurchaseAmount));
    }

    private void displayPurchaseResults() {
        List<LottoTicket> lottoTickets = ticketRepository.getLottoTickets();
        view.printPurchaseSize(lottoTickets.size());
        for (LottoTicket ticket : lottoTickets) {
            view.printPurchaseLottoTicket(ticket.toString());
        }
    }
}