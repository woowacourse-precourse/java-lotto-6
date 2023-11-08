package lotto;

public class LottoGame {
    public void process() {
        LottoTicket lottoTicket = UserInputErrorManager.checkAmount();
        lottoTicket.sortTickets();
        lottoTicket.displayTickets();

        Lotto lotto = UserInputErrorManager.checkLotto();

        Bonus bonus = UserInputErrorManager.checkBonus(lotto);

        LottoWinningRecord lottoWinningRecord = new LottoWinningRecord(lotto.getNumbers(), bonus.getNumber());
        lottoWinningRecord.calculateAndPrintStatistics(lottoTicket.getTickets(), lottoTicket.getQuantity() * 1000);
    }
}
