package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;

public class PlayerService {

    private final LottoService lottoService;

    private final Player player;

    private static PlayerService INSTANCE;

    private PlayerService(LottoService lottoService, Player player) {
        this.lottoService = lottoService;
        this.player = player;
    }

    public static PlayerService getInstance(LottoService lottoService, Player player) {
        if (INSTANCE == null) {
            INSTANCE = new PlayerService(lottoService, player);
        }
        return INSTANCE;
    }

    public List<Lotto> purchaseLotto(long buyingPrice) {
        player.setPrice(buyingPrice);
        long quantity = calculateQuantity();
        for (long i = 0; i < quantity; i++) {
            player.addLottoInPurchasedLotto(lottoService.generateLotto());
        }

        return player.getPurchasedLotto();
    }

    private long calculateQuantity() {
        return player.getPrice() / LOTTO_PRICE.getInfo();
    }

    public int[] compareLottoNumbers(List<Integer> inputNumbers, int bonusNumber) {
        List<Lotto> purchasedLotto = player.getPurchasedLotto();
        int[] lottoResult = new int[7];

        for (Lotto lotto : purchasedLotto) {
            int sameCount = lottoService.compareLotto(lotto, inputNumbers);
            if (sameCount == 5 && !lotto.isContainNumber(bonusNumber)) {
                lottoResult[3]++;
                continue;
            }

            if (sameCount == 0) {
                continue;
            }

            lottoResult[7 - sameCount]++;
        }

        return lottoResult;
    }

}
