package lotto.service;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;

public class PlayerService {

    private static final long LOTTO_PRICE = 1000;

    private Player player;

    private final LottoService lottoService = new LottoService();

    public List<Lotto> purchaseLotto(long inputPrice) {
        player = new Player(inputPrice);
        long quantity = calculateQuantity();
        for (long i = 0; i < quantity; i++) {
            player.addLottoInPurchasedLotto(lottoService.generateLotto());
        }

        return player.getPurchasedLotto();
    }

    private long calculateQuantity() {
        return player.getPrice() / LOTTO_PRICE;
    }

}
