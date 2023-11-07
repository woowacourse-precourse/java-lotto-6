package lotto.presentation.controller;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.model.LottoTicket;
import lotto.presentation.view.View;
import lotto.repository.LottoTicketRepository;
import lotto.service.Referee;

public class MC {
    private View view;
    private Referee referee;
    private LottoTicketRepository ticketRepository;

    public MC(View view, Referee referee, LottoTicketRepository ticketRepository) {
        this.view = view;
        this.referee = referee;
        this.ticketRepository = ticketRepository;
    }

    public void run() {
        view.promptForPurchaseAmount();
        int purchaseAmount = readAndValidateAmount();
        referee.generateLottoTickets(purchaseAmount);
        displayPurchaseResults();
    }

    private void displayPurchaseResults() {
        List<LottoTicket> lottoTickets = ticketRepository.getLottoTickets();
        view.printPurchaseSize(lottoTickets.size());
        for (LottoTicket ticket : lottoTickets) {
            ticket.sortNumbers();
            view.printPurchaseLottoTicket(ticket.toString());
        }
    }

    private int readAndValidateAmount() {
        while (true) {
            String inputPurchaseAmount = readAndRemoveSpace();
            try {
                getValidPurchaseAmount(inputPurchaseAmount);
                return Integer.parseInt(inputPurchaseAmount);
            } catch (IllegalArgumentException e) {
                view.promptForError(e);
                view.promptForPurchaseAmount();
            }
        }
    }

    private String readAndRemoveSpace() {
        return Console.readLine().replaceAll(" ", "");
    }

    private void getValidPurchaseAmount(String inputPurchaseAmount) {
        isNotBlankValue(inputPurchaseAmount);
        isNotIntegerValue(inputPurchaseAmount);
        isNotMultipleOfLottoPrice(inputPurchaseAmount);
    }

    // 에러 메세지 리터럴이니까 변경하기
    public void isNotBlankValue(final String inputPurchaseAmount) {
        if (inputPurchaseAmount.isBlank()) {
            throw new IllegalArgumentException("아무것도 입력하지 않으셨거나 빈 공백만 입력하셨습니다.");
        }
    }

    public void isNotIntegerValue(final String inputPurchaseAmount) {
        if (!inputPurchaseAmount.chars().allMatch(Character::isDigit)) {
            throw new IllegalArgumentException("로또 구입 금액은 정수여야 합니다.");
        }
    }

    public void isNotMultipleOfLottoPrice(final String inputPurchaseAmount) {
        // 조건문 고칠 수 있으면 고쳐봐
        int buyingCost = Integer.parseInt(inputPurchaseAmount);
        if (buyingCost < LottoTicket.PRICE || buyingCost % LottoTicket.PRICE != 0) {
            throw new IllegalArgumentException("로또 구입 금액은 로또 가격의 배수여야 합니다.");
        }
    }
}