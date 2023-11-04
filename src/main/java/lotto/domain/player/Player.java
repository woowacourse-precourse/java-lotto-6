package lotto.domain.player;

import lotto.domain.dto.LottoResultsDto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.player.playermoney.PlayerWallet;

public class Player {
    private final PlayerWallet playerWallet;
    private LottoTicket lottoTicket;

    public Player(int inputMoney) {
        this.playerWallet = new PlayerWallet(inputMoney);
        this.lottoTicket = new LottoTicket(0);
    }

    public void consumeAllMoneyToLottoTicket() {
        playerWallet.consumeMoneyToLottoTicket(playerWallet.getHoldingMoney());
        lottoTicket = lottoTicket.issueLottoTicket(playerWallet);
    }

    public void buyRandomLottoWithAllTicket(Lotto randomLotto, LottoBundle lottoBundle) {
        lottoTicket = lottoTicket.changeAllTicketToLotto(randomLotto, lottoBundle);
    }

    public int getTicketNumber() {
        return lottoTicket.getLottoTicket();
    }

    public Profit getProfit(LottoResultsDto lottoResultsDto) {
        return  playerWallet.calculateProfit(lottoResultsDto);
    }
}
