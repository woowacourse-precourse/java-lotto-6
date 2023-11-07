package lotto.model;

import java.util.List;

public class Game {

    private final LottoStore lottoStore;
    private final WinningNumber winningNumber;
    private LottoTickets issuedLottoTickets;

    public Game(LottoStore lottoStore) {
        this.lottoStore = lottoStore;
        this.winningNumber = new WinningNumber();
    }

    public void purchaseLottoTickets(int purchaseAmount) {
        this.issuedLottoTickets = lottoStore.purchaseRandomLottoTickets(purchaseAmount);
    }

    public int getNumberOfLottoIssued() {
        return issuedLottoTickets.getSize();
    }

    public List<Lotto> getIssuedLottoTickets() {
        return issuedLottoTickets.getTickets();
    }

    public void setWinningNumbers(List<Integer> winningNumber) {
        this.winningNumber.setWinningNumber(new Lotto(winningNumber));
    }

    public void setBonusNumber(int bonusNumber) {
        this.winningNumber.setBonusNumber(bonusNumber);
    }

}
