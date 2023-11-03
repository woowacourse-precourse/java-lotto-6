package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;

public class PlayerService {

    private final LottoService lottoService = new LottoService();

    private Player player;

    public List<Lotto> purchaseLotto(long buyingPrice) {
        player = new Player(buyingPrice);
        long quantity = calculateQuantity();
        for (long i = 0; i < quantity; i++) {
            player.addLottoInPurchasedLotto(lottoService.generateLotto());
        }

        return player.getPurchasedLotto();
    }

    private long calculateQuantity() {
        return player.getPrice() / LOTTO_PRICE.getInfo();
    }

}
