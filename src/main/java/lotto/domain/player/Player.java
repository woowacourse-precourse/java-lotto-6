package lotto.domain.player;

import java.util.function.Supplier;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.lotto.Lotto;
import lotto.domain.lottoresult.LottoPrizeMoney;
import lotto.domain.player.playermoney.PlayerWallet;

public class Player {
    private final PlayerWallet playerWallet;
    private final LottoBundle lottoBundle;
    private LottoTicket lottoTicket;

    public Player(int inputMoney, LottoBundle lottoBundle) {
        this.playerWallet = new PlayerWallet(inputMoney);
        this.lottoBundle = lottoBundle;
        this.lottoTicket = LottoTicket.makeZeroLottoTicket();
    }

    public void buyAndSaveRandomLottoWithAllTicket(Supplier<Lotto> randomLottoSupplier) {
        lottoTicket = consumeAllMoneyToLottoTicket();
        lottoTicket = lottoTicket.changeAllTicketToLotto(randomLottoSupplier, lottoBundle);
    }

    LottoTicket consumeAllMoneyToLottoTicket() {
        playerWallet.consumeMoneyToLottoTicket(playerWallet.getHoldingMoney());
        return playerWallet.issueLottoTicket();
    }

    public Profit getProfit(LottoPrizeMoney lottoPrizeMoney) {
        return  playerWallet.calculateProfit(lottoPrizeMoney);
    }

    public LottoBundleDto makeLottoBundleDto() {
        return lottoBundle.makeLottoBundleDto();
    }
}
