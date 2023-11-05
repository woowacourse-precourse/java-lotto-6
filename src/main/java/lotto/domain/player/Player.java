package lotto.domain.player;

import java.util.function.Supplier;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottoresult.LottoResultsRepository;
import lotto.domain.player.playermoney.PlayerWallet;

public class Player {
    private final PlayerWallet playerWallet;
    private LottoTicket lottoTicket;

    public Player(int inputMoney) {
        this.playerWallet = new PlayerWallet(inputMoney);
        this.lottoTicket = LottoTicket.makeZeroLottoTicket();
    }

    public void consumeAllMoneyToLottoTicket() {
        playerWallet.consumeMoneyToLottoTicket(playerWallet.getHoldingMoney());
        lottoTicket = lottoTicket.issueLottoTicket(playerWallet);
    }

    public void buyRandomLottoWithAllTicket(Supplier<Lotto> randomLotto, LottoBundle lottoBundle) {
        lottoTicket = lottoTicket.changeAllTicketToLotto(randomLotto, lottoBundle);
    }

    public Profit getProfit(LottoResultsRepository lottoResultsRepository) {
        return  playerWallet.calculateProfit(lottoResultsRepository);
    }

    // 테스트를 위한 코드
    int getTicketNumber() {
        return lottoTicket.getLottoTicket();
    }
}
