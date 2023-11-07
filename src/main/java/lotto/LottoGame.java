package lotto;

public class LottoGame {
    public void process() {
        LottoTicket lottoTicket = UserInputErrorManager.getuntilNotInvalidAmount();
        lottoTicket.sortTickets();
        lottoTicket.displayTickets();

        Lotto lotto = UserInputErrorManager.getuntilNotInvalidLotto();

        Bonus bonus = UserInputErrorManager.getuntilNotInvalidBonus(lotto);

        LottoWinningRecord lottoWinningRecord = new LottoWinningRecord(lotto.getNumbers(), bonus.getNumber());
        lottoWinningRecord.calculateAndPrintStatistics(lottoTicket.getTickets(), lottoTicket.getQuantity() * 1000);
    }
}
