package view;

import static constant.OutputMessage.*;

public class OutputView {
    public void inputPurchaseAmount() {
        System.out.print(INPUT_PURCHASE_AMOUNT.get());
    }

    public void buyLottoes(int count) {
        System.out.print(BUY_LOTTOES.get(count));
    }

    public void lottoTickets(List<LottoTicketDto> lottoTicketDtoes) {

    }

    public void inputWinningNumber() {
        System.out.print(INPUT_WINNING_NUMBER.get());
    }

    public void inputBonusNumber() {
        System.out.print(INPUT_BONUS_NUMBER.get());
    }

    public void inputWinningStatistics() {
        System.out.print(INPUT_WINNING_STATISTICS.get());
    }

    public void matchCount() {
        System.out.print(MATCH_COUNT.get());
    }

    public void matchCountRank2() {
        System.out.print(MATCH_COUNT_RANK_2.get());
    }

    public void totalRateOfReturn() {
        System.out.print(TOTAL_RATE_OF_RETURN.get());
    }
}
