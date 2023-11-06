package lotto.view;

import lotto.config.LottoMessage;
import lotto.dto.response.LottoResultsDto;
import lotto.dto.response.LottoTicketsDto;

import java.util.List;

public class OutputView {

    public OutputView() {
    }

    public void printEnterPurchaseAmount() {
        printMessage(LottoMessage.ENTER_PURCHASE_AMOUNT.getMessage());
    }

    public void printTicketPurchasedCount(LottoTicketsDto lottoTicketsDto) {
        int ticketCount = lottoTicketsDto.getLottoTicketCount();
        printMessage(LottoMessage.TICKET_PURCHASED_COUNT.getFormattedMessage(ticketCount));
        printTickets(lottoTicketsDto);
    }

    private void printTickets(LottoTicketsDto lottoTicketsDto) {
        for (List<String> lottoTicket : lottoTicketsDto.getFormattedLottoTickets()) {
            printMessage(lottoTicket);
        }
    }

    public void printEnterWinningNumbers() {
        printMessage(LottoMessage.ENTER_WINNING_NUMBERS.getMessage());
    }

    public void printEnterBonusNumber() {
        printMessage(LottoMessage.ENTER_BONUS_NUMBER.getMessage());
    }

    public void printMatchResult(LottoResultsDto lottoResultsDTO) {
        printMessage(LottoMessage.WINNING_STATISTICS_HEADER.getMessage());
        printMessage(lottoResultsDTO.getResults());
    }

    public void printTotalProfitRate(LottoResultsDto lottoResultsDTO) {
        float profitRate = lottoResultsDTO.getProfitRate();
        printMessage(LottoMessage.TOTAL_PROFIT_RATE.getFormattedMessage(profitRate));
    }

    private void printMessage(Object message) {
        System.out.println(message);
    }

    public static OutputView getInstance() {
        return OutputView.LazyHolder.INSTANCE;
    }


    private static class LazyHolder {
        private static final OutputView INSTANCE = new OutputView();
    }

}