package lotto.domain.service;

import java.util.function.Supplier;
import lotto.domain.dto.LottoBundleDto;
import lotto.domain.lotto.Lotto;
import lotto.domain.lotto.LottoBundle;
import lotto.domain.player.Player;

public class LottoPurchaseService {

    private final LottoBundle lottoBundle;

    public LottoPurchaseService(LottoBundle lottoBundle) {
        this.lottoBundle = lottoBundle;
    }

    public Player purchaseLotto(Player player, Supplier<Lotto> lottoSupplier) {
        player.consumeAllMoneyToLottoTicket();
        player.buyRandomLottoWithAllTicket(lottoSupplier, lottoBundle);
        return player;
    }

    public LottoBundleDto makeLottoBundleDto() {
        return lottoBundle.makeLottoBundleDto();
    }
}
