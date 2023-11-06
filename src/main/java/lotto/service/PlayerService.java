package lotto.service;

import static lotto.constant.LottoInfo.LOTTO_PRICE;
import static lotto.constant.LottoInfo.LOTTO_SIZE;
import static lotto.constant.LottoInfo.MINIMUM_NUMBER;
import static lotto.constant.LottoResult.FIFTH_PLACE;
import static lotto.constant.LottoResult.FIRST_PLACE;
import static lotto.constant.LottoResult.FOURTH_PLACE;
import static lotto.constant.LottoResult.SECOND_PLACE;
import static lotto.constant.LottoResult.THIRD_PLACE;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.MatchedLottoCount;
import lotto.domain.Player;

public class PlayerService {

    private static final int FIRST_PLACE_INDEX = 1;
    private static final int SECOND_PLACE_INDEX = 0;
    private static final int THIRD_PLACE_INDEX = 2;
    private static final int FOURTH_PLACE_INDEX = 3;
    private static final int FIFTH_PLACE_INDEX = 4;

    private final LottoService lottoService;

    private final Player player;

    private static PlayerService INSTANCE;

    private MatchedLottoCount matchedLottoCount;

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

    public MatchedLottoCount compareLottoNumbers(List<Integer> inputNumbers, int bonusNumber) {
        List<Lotto> purchasedLotto = player.getPurchasedLotto();
        matchedLottoCount = new MatchedLottoCount();

        for (Lotto lotto : purchasedLotto) {
            int sameCount = lottoService.compareLotto(lotto, inputNumbers);
            if (sameCount == 5 && !lotto.isContainNumber(bonusNumber)) {
                matchedLottoCount.incrementLottoCount(SECOND_PLACE_INDEX);
            } else if (sameCount >= MINIMUM_NUMBER.getInfo() && sameCount <= LOTTO_SIZE.getInfo()) {
                matchedLottoCount.incrementLottoCount(7 - sameCount);
            }
        }

        return matchedLottoCount;
    }

    public float calculateRateOfReturn() {
        return (float) (FIRST_PLACE.calculateAward(matchedLottoCount.getPlaceCount(FIRST_PLACE_INDEX))
                + SECOND_PLACE.calculateAward(matchedLottoCount.getPlaceCount(SECOND_PLACE_INDEX))
                + THIRD_PLACE.calculateAward(matchedLottoCount.getPlaceCount(THIRD_PLACE_INDEX))
                + FOURTH_PLACE.calculateAward(matchedLottoCount.getPlaceCount(FOURTH_PLACE_INDEX))
                + FIFTH_PLACE.calculateAward(matchedLottoCount.getPlaceCount(FIFTH_PLACE_INDEX))) / player.getPrice();
    }

}
