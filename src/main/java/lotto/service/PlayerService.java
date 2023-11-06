package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoResult.FIFTH_PLACE;
import static lotto.constant.LottoResult.FIRST_PLACE;
import static lotto.constant.LottoResult.FOURTH_PLACE;
import static lotto.constant.LottoResult.SECOND_PLACE;
import static lotto.constant.LottoResult.THIRD_PLACE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;

public class PlayerService {

    private final LottoService lottoService;

    private final Player player;

    private static PlayerService INSTANCE;

    private int[] lottoResult = new int[LOTTO_SIZE.getInfo() + 2];

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

        for (Lotto lotto : purchasedLotto) {
            int sameCount = lottoService.compareLotto(lotto, inputNumbers);
            if (sameCount == 5 && !lotto.isContainNumber(bonusNumber)) {
                lottoResult[0]++;
                continue;
            }

            if (sameCount == 0) {
                continue;
            }

            lottoResult[7 - sameCount]++;
        }

        return lottoResult;
    }

    public float calculateRateOfReturn() {
        return (float) (FIRST_PLACE.calculateAward(lottoResult[1]) + SECOND_PLACE.calculateAward(lottoResult[0])
                + THIRD_PLACE.calculateAward(lottoResult[2]) + FOURTH_PLACE.calculateAward(lottoResult[3])
                + FIFTH_PLACE.calculateAward(lottoResult[4])) / player.getPrice();
    }

}
